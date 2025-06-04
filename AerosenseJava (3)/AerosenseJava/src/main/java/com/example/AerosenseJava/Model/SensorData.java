package com.example.AerosenseJava.Model;

public class SensorData {
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private String timestamp;

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    private double temperature;

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    private double humidity;

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    private double co2;

    public double getDust() {
        return dust;
    }

    public void setDust(double dust) {
        this.dust = dust;
    }

    private double dust;
}
