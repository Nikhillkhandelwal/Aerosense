package com.example.AerosenseJava.Model;

public class AlertStatus {
    private boolean asthmaRisk;
    private boolean copdRisk;

    public boolean isCopdRisk() {
        return copdRisk;
    }

    public void setCopdRisk(boolean copdRisk) {
        this.copdRisk = copdRisk;
    }

    public boolean isAsthmaRisk() {
        return asthmaRisk;
    }

    public void setAsthmaRisk(boolean asthmaRisk) {
        this.asthmaRisk = asthmaRisk;
    }

    public boolean isHeartAttackRisk() {
        return heartAttackRisk;
    }

    public void setHeartAttackRisk(boolean heartAttackRisk) {
        this.heartAttackRisk = heartAttackRisk;
    }

    private boolean heartAttackRisk;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    public boolean isSafe() {
        return !asthmaRisk && !copdRisk && !heartAttackRisk;
    }
}
