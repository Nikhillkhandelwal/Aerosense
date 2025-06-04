package com.example.AerosenseJava.controller;

import com.example.AerosenseJava.Model.AlertStatus;
import com.example.AerosenseJava.Model.SensorData;
import com.example.AerosenseJava.service.AlertService;
import com.example.AerosenseJava.service.ThingSpeakService;

import com.example.AerosenseJava.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;


@Controller
public class ThingSpeakController {

    private final ThingSpeakService thingSpeakService;
    @Autowired
    private ChartService chartService;
    @Autowired
    private AlertService alertService;

    @Autowired
    public ThingSpeakController(ThingSpeakService thingSpeakService) {
        this.thingSpeakService = thingSpeakService;
    }

    @GetMapping("/data")
    public String getData(Model model){
        SensorData latest =thingSpeakService.getChannelId();
        List<SensorData> lastTen=thingSpeakService.getLastTenReadings();
        AlertStatus alertStatus= alertService.analyzeAlerts(latest);
        model.addAttribute("latest",latest);
        model.addAttribute("lastTen",lastTen);
        model.addAttribute("alerts",alertStatus);
        return "front";






    }
}
