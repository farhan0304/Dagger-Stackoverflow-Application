package com.example.distackoverflowapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answers {

    @SerializedName("is_accepted")
    @Expose
    boolean isAccepted;

    @SerializedName("score")
    @Expose
    int score;

    @SerializedName("content_license")
    @Expose
    String contentLicense;

    public Answers() {
    }

    public Answers(boolean isAccepted, int score, String contentLicense) {
        this.isAccepted = isAccepted;
        this.score = score;
        this.contentLicense = contentLicense;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContentLicense() {
        return contentLicense;
    }

    public void setContentLicense(String contentLicense) {
        this.contentLicense = contentLicense;
    }
}
