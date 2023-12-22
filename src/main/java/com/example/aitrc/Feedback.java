package com.example.aitrc;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Feedback {
    private String ansA;
    private String ansB;
    private String ansC;
    private String ansD;

    public Feedback() {
    }

    public String getAnsA() {
        return ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public Feedback(String ansA, String ansB, String ansC, String ansD) {
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
    }
}
