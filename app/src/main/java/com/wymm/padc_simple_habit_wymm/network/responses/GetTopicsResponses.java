package com.wymm.padc_simple_habit_wymm.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class GetTopicsResponses extends BaseResponse{
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("topics")
    @Expose
    private List<TopicsVO> topics;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<TopicsVO> getTopics() {
        if (topics == null) {
            return new ArrayList<>();
        }
        return topics;
    }

    public void setTopics(List<TopicsVO> topics) {
        this.topics = topics;
    }
}
