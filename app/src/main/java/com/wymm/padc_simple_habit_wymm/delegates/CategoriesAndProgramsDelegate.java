package com.wymm.padc_simple_habit_wymm.delegates;

import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public interface CategoriesAndProgramsDelegate {
    void onSuccess(List<CategoriesAndProgramsVO> categoriesAndProgramsVOList);
    void onFail(String message);
}
