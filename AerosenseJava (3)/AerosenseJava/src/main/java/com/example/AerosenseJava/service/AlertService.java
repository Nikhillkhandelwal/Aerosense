package com.example.AerosenseJava.service;

import com.example.AerosenseJava.Model.AlertStatus;
import com.example.AerosenseJava.Model.SensorData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {
  public AlertStatus analyzeAlerts(SensorData data){
      AlertStatus alert=new AlertStatus();
      if(data.getCo2()>1000||data.getDust()>150){
          alert.setAsthmaRisk(true);
          alert.setMessage("Asthma risk due to poor air quality!");
      }
      if(data.getCo2()>1200 && data.getTemperature()>35){
          alert.setCopdRisk(true);
          alert.setMessage("COPD risk detected!");
      }
      if(data.getCo2()>1500|| data.getHumidity()<30){
          alert.setHeartAttackRisk(true);
          alert.setMessage("Heart attack risk due to extreme Conditions !");
      }
      return alert;
  }

}
