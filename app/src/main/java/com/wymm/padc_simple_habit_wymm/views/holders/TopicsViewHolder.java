package com.wymm.padc_simple_habit_wymm.views.holders;

import android.view.View;

import com.wymm.padc_simple_habit_wymm.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class TopicsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_topic_name)
    public AppCompatTextView tvTopicName;

    @BindView(R.id.tv_topic_desc)
    public AppCompatTextView tvTopicDesc;

    @BindView(R.id.tv)
    public AppCompatTextView tvTopic;

    public TopicsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
