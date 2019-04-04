package com.wymm.padc_simple_habit_wymm.data.model;

import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramDelegate;
import com.wymm.padc_simple_habit_wymm.network.RetrofitDataAgent;
import com.wymm.padc_simple_habit_wymm.network.SimpleHabitDataAgent;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class CurrentProgramModelImpl implements CurrentProgramModel {

    private static CurrentProgramModelImpl objInstance;

    public static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private CurrentProgramVO mCurrentProgramVO;

    private SimpleHabitDataAgent mDataAgent;

    public CurrentProgramModelImpl() {
        mDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static CurrentProgramModelImpl getObjInstance(){
        if (objInstance == null) {
            objInstance = new CurrentProgramModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getCurrentProgramVO(final CurrentProgramDelegateToView currentProgramDelegateToView) {
        mDataAgent.getCurrentProgram(1, ACCESS_TOKEN,
                new CurrentProgramDelegate() {
                    @Override
                    public void onSuccess(CurrentProgramVO currentProgramVO) {
                        mCurrentProgramVO = currentProgramVO;
                        currentProgramDelegateToView.onCurrentProgramFetchFromNetwork(currentProgramVO);
                    }

                    @Override
                    public void onFail(String message) {
                        currentProgramDelegateToView.onErrorCurrentProgramFetch(message);
                    }
                });
    }
}
