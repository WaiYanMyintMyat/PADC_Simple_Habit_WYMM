package com.wymm.padc_simple_habit_wymm.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class ProgramVO extends BaseVO{
    @SerializedName("program-id")
    @Expose
    private String programId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private String image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Integer> getAverageLengths() {
        if (averageLengths == null) {
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
