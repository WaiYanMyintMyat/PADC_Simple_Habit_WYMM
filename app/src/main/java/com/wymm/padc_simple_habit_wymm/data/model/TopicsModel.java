package com.wymm.padc_simple_habit_wymm.data.model;

import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public interface TopicsModel {
    void getTopicsList(TopicsDelegateToView topicsDelegateToView);

    interface TopicsDelegateToView {
        void onTopicsFetchFromNetwork(List<TopicsVO> topicsVOList);

        void onErrorTopicsFetch(String message);
    }
}
