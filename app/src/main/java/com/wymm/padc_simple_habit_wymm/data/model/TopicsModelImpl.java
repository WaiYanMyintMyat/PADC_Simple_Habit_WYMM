package com.wymm.padc_simple_habit_wymm.data.model;

import android.content.Context;
import android.util.Log;

import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;
import com.wymm.padc_simple_habit_wymm.delegates.TopicsDelegate;
import com.wymm.padc_simple_habit_wymm.network.RetrofitDataAgent;
import com.wymm.padc_simple_habit_wymm.network.SimpleHabitDataAgent;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class TopicsModelImpl extends BaseModel implements TopicsModel{
    private static TopicsModelImpl objInstance;

    public TopicsModelImpl(Context context) {
        super(context);
    }

    public static void initTopicsModel(Context context){
        objInstance = new TopicsModelImpl(context);
    }

    public static TopicsModelImpl getObjInstance() {
        if (objInstance == null) {
            throw new RuntimeException("TopicModel shold have been initaialized before using it.");
        }
        return objInstance;
    }

    @Override
    public List<TopicsVO> getTopicsList(final TopicsDelegateToView topicsDelegateToView) {
        if (mSimpleHabitDB.isEmptyTopicVOTable()){
            mDataAgent.getTopics(1, CurrentProgramModelImpl.ACCESS_TOKEN,
                    new TopicsDelegate() {
                        @Override
                        public void onSuccess(List<TopicsVO> topicsVOList) {
                            long[] topicName = mSimpleHabitDB.topicsDao().insertTopicsList(topicsVOList);
                            Log.d("topicname",topicName[0]+"");
                            List<TopicsVO> topicListFromDB = mSimpleHabitDB.topicsDao().selectTopicsList();
                            topicsDelegateToView.onTopicsFetchFromNetwork(topicListFromDB);
                        }

                        @Override
                        public void onFail(String message) {
                            topicsDelegateToView.onErrorTopicsFetch(message);
                        }
                    });
        } else {
            List<TopicsVO> topicsVOList = mSimpleHabitDB.topicsDao().selectTopicsList();
            return topicsVOList;
        }
        return null;
    }
}
