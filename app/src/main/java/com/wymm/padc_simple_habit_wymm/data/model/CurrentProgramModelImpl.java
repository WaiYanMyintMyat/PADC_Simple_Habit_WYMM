package com.wymm.padc_simple_habit_wymm.data.model;

import android.content.Context;
import android.util.Log;

import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramDelegate;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class CurrentProgramModelImpl extends BaseModel implements CurrentProgramModel {

    public static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private static CurrentProgramModelImpl objInstance;

    public CurrentProgramModelImpl(Context context) {
        super(context);
    }

    public static void initCurrentProgramModel(Context context) {
        objInstance = new CurrentProgramModelImpl(context);
    }

    public static CurrentProgramModelImpl getObjInstance() {
        if (objInstance == null) {
            throw new RuntimeException("CurrentProgramModel shold have been initaialized before using it.");
        }
        return objInstance;
    }

    @Override
    public CurrentProgramVO getCurrentProgramVO(final CurrentProgramDelegateToView currentProgramDelegateToView) {
        if (mSimpleHabitDB.isEmptyCurrentProgramVoTable()){
            mDataAgent.getCurrentProgram(1, ACCESS_TOKEN,
                    new CurrentProgramDelegate() {
                        @Override
                        public void onSuccess(CurrentProgramVO currentProgramVO) {
                            long currentProgramId = mSimpleHabitDB.currentProgramDao().insertCurrentProgram(currentProgramVO);
                            Log.d("current_program_id", currentProgramId + "");
                            CurrentProgramVO currentProgramVOFromDB = mSimpleHabitDB.currentProgramDao().getCurrentProgram();
                            currentProgramDelegateToView.onCurrentProgramFetchFromNetwork(currentProgramVOFromDB);
                        }

                        @Override
                        public void onFail(String message) {
                            currentProgramDelegateToView.onErrorCurrentProgramFetch(message);
                        }
                    });
        } else {
            CurrentProgramVO currentProgramVO = mSimpleHabitDB.currentProgramDao().getCurrentProgram();
            return currentProgramVO;
        }
        return null;
    }
}
