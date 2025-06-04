package com.example.AerosenseJava.service;

import com.example.AerosenseJava.Model.SensorData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThingSpeakService {
    private static final Logger log = LoggerFactory.getLogger(ThingSpeakService.class);
    @Value("${thingspeak.channelId}")
    private String channelId;
    @Value("${thingspeak.apiKey}")
    private String apiKey;

    private final RestTemplate restTemplate=new RestTemplate();

    public SensorData getChannelId(){
        String url = "https://api.thingspeak.com/channels/" + channelId + "/feeds.json?api_key=" + apiKey + "&results=1";
        String response = restTemplate.getForObject(url, String.class);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response);
            JsonNode feed = json.get("feeds").get(0);
            return mapJsonToSensorData(feed);
        } catch (Exception e) {
            log.error("Error parsing ThingSpeak response", e);
            return null;
        }


    }
    public List<SensorData> getLastTenReadings(){
        String url="https://api.thingspeak.com/channels/" + channelId + "/feeds.json?api_key=" + apiKey + "&results=10";
        JsonNode json= restTemplate.getForObject(url, JsonNode.class);
        List<SensorData> readings=new ArrayList<>();

        if(json !=null && json.has("feeds")){
            for(JsonNode feed: json.get("feeds")){
                readings.add(mapJsonToSensorData(feed));
            }
        }
        return readings;
    }
    private SensorData mapJsonToSensorData(JsonNode feed) {
        SensorData data = new SensorData();
        data.setTimestamp(feed.get("created_at").asText());
        data.setTemperature(Double.parseDouble(feed.get("field3").asText()));
        data.setHumidity(Double.parseDouble(feed.get("field4").asText()));
        data.setCo2(Double.parseDouble(feed.get("field2").asText()));
        data.setDust(Double.parseDouble(feed.get("field1").asText()));
        return data;
    }


}
