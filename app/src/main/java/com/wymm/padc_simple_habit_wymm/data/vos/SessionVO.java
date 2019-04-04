package com.wymm.padc_simple_habit_wymm.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class SessionVO {
    @SerializedName("session-id")
    @Expose
    private String sessionId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("length-in-seconds")
    @Expose
    private Integer lengthInSeconds;
    @SerializedName("file-path")
    @Expose
    private String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(Integer lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
