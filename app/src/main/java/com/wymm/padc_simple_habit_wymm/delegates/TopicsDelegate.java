package com.wymm.padc_simple_habit_wymm.delegates;

import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public interface TopicsDelegate {
    void onSuccess(List<TopicsVO> topicsVOList);
    void onFail(String message);
}
