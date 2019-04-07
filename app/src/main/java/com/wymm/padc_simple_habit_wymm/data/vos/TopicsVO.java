package com.wymm.padc_simple_habit_wymm.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
@Entity(tableName = "topics")
public class TopicsVO extends BaseVO{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "topic_name")
    @SerializedName("topic-name")
    @Expose
    private String topicName;

    @ColumnInfo(name = "topic_desc")
    @SerializedName("topic-desc")
    @Expose
    private String topicDesc;

    @ColumnInfo(name = "icon")
    @SerializedName("icon")
    @Expose
    private String icon;

    @ColumnInfo(name = "backgroud")
    @SerializedName("background")
    @Expose
    private String background;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
