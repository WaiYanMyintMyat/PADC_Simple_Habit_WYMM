package com.wymm.padc_simple_habit_wymm.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class GetCurrentProgramResponse extends BaseResponse{
    @SerializedName("currentProgram")
    @Expose
    private CurrentProgramVO currentProgram;

    public CurrentProgramVO getCurrentProgram() {
        return currentProgram;
    }

    public void setCurrentProgram(CurrentProgramVO currentProgram) {
        this.currentProgram = currentProgram;
    }
}
