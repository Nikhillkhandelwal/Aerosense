package com.example.AerosenseJava.service;

import com.example.AerosenseJava.Model.SensorData;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ChartService {

    public JFreeChart generateTemperatureChart(List<SensorData> history) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (SensorData data : history) {
            dataset.addValue(data.getTemperature(), "Temperature", data.getTimestamp());
        }
        JFreeChart chart=ChartFactory.createLineChart(
                "Temperature over Time",
                "Time",
                "Temperature (°C)",
                dataset
        );
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot=(CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(230, 230, 230));
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        return chart;


    }
    public JFreeChart generateHumidityChart(List<SensorData> history)
    {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        for(SensorData data:history){
            dataset.addValue(data.getHumidity(),"Humidity",data.getTimestamp());

        }
        JFreeChart chart=ChartFactory.createLineChart("Humidity over time",
                "Time",
                "Humidtiy",
                dataset);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot=(CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(230, 230, 230));
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        return chart;

    }

    public JFreeChart generateC02Chart(List<SensorData>history){
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        for(SensorData data:history){
            dataset.addValue(data.getCo2(),"Co2",data.getTimestamp());
        }
        JFreeChart chart= ChartFactory.createLineChart("Co2 over time","Time","Co2",dataset);
        chart.setBackgroundPaint(Color.white);

        CategoryPlot plot=(CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(230, 230, 230));
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        return chart;
    }
    public JFreeChart generateDust(List<SensorData>history){
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        for(SensorData data:history){
            dataset.addValue(data.getDust(),"Dust",data.getTimestamp());
        }
        JFreeChart chart=ChartFactory.createLineChart("Dust over time","Time","Co2",dataset);
        CategoryPlot plot=(CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(new Color(230, 230, 230));
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        return chart;
    }


}
