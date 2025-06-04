package com.example.AerosenseJava.controller;

import com.example.AerosenseJava.service.ChartService;
import com.example.AerosenseJava.service.ThingSpeakService;
import jakarta.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;

@RestController
public class ChartController {

    @Autowired
    private ThingSpeakService thingSpeakService;

    @Autowired
    private ChartService chartService;

    @GetMapping("/chart/temperature")
    public void renderTemperatureChart(HttpServletResponse response) throws IOException {
        var sensorData = thingSpeakService.getLastTenReadings();
        JFreeChart chart = chartService.generateTemperatureChart(sensorData);
        response.setContentType("image/png");
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 400);
    }
    @GetMapping("chart/humidity")
    public void renderHumidityChart(HttpServletResponse response) throws IOException
    {
        var sensorData = thingSpeakService.getLastTenReadings();
        JFreeChart chart = chartService.generateHumidityChart(sensorData);
        response.setContentType("image/png");
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 400);

    }
    @GetMapping("chart/Co2")
    public void renderCo2Chart(HttpServletResponse response) throws IOException
    {
        var sensorData = thingSpeakService.getLastTenReadings();
        JFreeChart chart = chartService.generateC02Chart(sensorData);
        response.setContentType("image/png");
        ChartUtils.writeChartAsPNG(response.getOutputStream(), chart, 800, 400);

    }
    @GetMapping("chart/dust")
    public void renderDustChart(HttpServletResponse response) throws IOException{
        var sensorData=thingSpeakService.getLastTenReadings();
        JFreeChart chart= chartService.generateDust(sensorData);
        response.setContentType("image/png");
        ChartUtils.writeChartAsPNG(response.getOutputStream(),chart,800,400);
    }
}
