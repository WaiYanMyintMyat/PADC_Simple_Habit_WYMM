package com.wymm.padc_simple_habit_wymm.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class CurrentProgramVO extends BaseVO{
    @SerializedName("program-id")
    @Expose
    private String programId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("current-period")
    @Expose
    private String currentPeriod;
    @SerializedName("background")
    @Expose
    private String background;
    @SerializedName("average-lengths")
    @Expose
    private List<Integer> averageLengths;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("sessions")
    @Expose
    private List<SessionVO> sessions;

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public List<Integer> getAverageLengths() {
        if (averageLengths == null){
            return new ArrayList<>();
        }
        return averageLengths;
    }

    public void setAverageLengths(List<Integer> averageLengths) {
        this.averageLengths = averageLengths;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SessionVO> getSessions() {
        if (sessions == null) {
            return new ArrayList<>();
        }
        return sessions;
    }

    public void setSessions(List<SessionVO> sessions) {
        this.sessions = sessions;
    }
}
