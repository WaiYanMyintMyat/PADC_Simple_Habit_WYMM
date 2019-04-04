package com.wymm.padc_simple_habit_wymm.views.holders;

import android.view.View;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class TopicsViewHolder extends BaseViewHolder<TopicsVO> {
    @BindView(R.id.tv_topic_name)
    public AppCompatTextView tvTopicName;

    @BindView(R.id.tv_topic_desc)
    public AppCompatTextView tvTopicDesc;

    @BindView(R.id.tv)
    public AppCompatTextView tvTopic;

    public TopicsViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
