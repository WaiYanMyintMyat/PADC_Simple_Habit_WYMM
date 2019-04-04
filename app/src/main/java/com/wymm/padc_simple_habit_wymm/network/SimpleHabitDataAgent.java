package com.wymm.padc_simple_habit_wymm.network;

import com.wymm.padc_simple_habit_wymm.delegates.CategoriesAndProgramsDelegate;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramDelegate;
import com.wymm.padc_simple_habit_wymm.delegates.TopicsDelegate;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public interface SimpleHabitDataAgent {
    void getCurrentProgram(int page, String accessToken, CurrentProgramDelegate currentProgramDelegate);

    void getCategoriesAndPrograms(int page, String accessToken, CategoriesAndProgramsDelegate categoriesAndProgramsDelegate);

    void getTopics(int page, String accessToken, TopicsDelegate topicsDelegate);
}
