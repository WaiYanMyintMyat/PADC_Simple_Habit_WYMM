package com.wymm.padc_simple_habit_wymm.delegates;

import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public interface CurrentProgramDelegate {
    void onSuccess(CurrentProgramVO currentProgramVO);
    void onFail(String message);
}
