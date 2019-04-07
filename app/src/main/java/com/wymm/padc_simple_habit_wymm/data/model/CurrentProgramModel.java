package com.wymm.padc_simple_habit_wymm.data.model;

import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public interface CurrentProgramModel {
    CurrentProgramVO getCurrentProgramVO(CurrentProgramDelegateToView currentProgramDelegateToView);

    interface CurrentProgramDelegateToView {
        void onCurrentProgramFetchFromNetwork (CurrentProgramVO currentProgramVO);
        void onErrorCurrentProgramFetch (String message);
    }
}
