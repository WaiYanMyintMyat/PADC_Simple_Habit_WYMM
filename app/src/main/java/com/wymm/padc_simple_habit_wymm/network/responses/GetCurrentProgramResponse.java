package com.wymm.padc_simple_habit_wymm.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class GetCurrentProgramResponse {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("apiVersion")
    @Expose
    private String apiVersion;
    @SerializedName("currentProgram")
    @Expose
    private CurrentProgramVO currentProgram;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(CurrentProgramVO currentProgram) {
        this.currentProgram = currentProgram;
    }

    public boolean isResponseSuccess(){
        return code==200;
    }
}
