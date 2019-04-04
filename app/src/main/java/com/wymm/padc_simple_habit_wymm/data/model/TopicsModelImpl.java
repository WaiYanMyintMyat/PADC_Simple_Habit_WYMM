package com.wymm.padc_simple_habit_wymm.data.model;

import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;
import com.wymm.padc_simple_habit_wymm.delegates.TopicsDelegate;
import com.wymm.padc_simple_habit_wymm.network.RetrofitDataAgent;
import com.wymm.padc_simple_habit_wymm.network.SimpleHabitDataAgent;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class TopicsModelImpl implements TopicsModel{
    private static TopicsModelImpl objInstance;
    private SimpleHabitDataAgent mDataAgent;

    public TopicsModelImpl() {
        mDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static TopicsModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new TopicsModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getTopicsList(final TopicsDelegateToView topicsDelegateToView) {
        mDataAgent.getTopics(1, CurrentProgramModelImpl.ACCESS_TOKEN,
                new TopicsDelegate() {
                    @Override
                    public void onSuccess(List<TopicsVO> topicsVOList) {
                        topicsDelegateToView.onTopicsFetchFromNetwork(topicsVOList);
                    }

                    @Override
                    public void onFail(String message) {
                        topicsDelegateToView.onErrorTopicsFetch(message);
                    }
                });
    }
}
