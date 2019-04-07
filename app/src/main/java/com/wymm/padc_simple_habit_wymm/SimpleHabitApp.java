package com.wymm.padc_simple_habit_wymm;

import android.app.Application;

import com.wymm.padc_simple_habit_wymm.data.model.CategoriesAndProgramsModelImpl;
import com.wymm.padc_simple_habit_wymm.data.model.CurrentProgramModelImpl;
import com.wymm.padc_simple_habit_wymm.data.model.TopicsModelImpl;

/**
 * Created by Wai Yan Myint Myat on 4/6/19.
 */
public class SimpleHabitApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CurrentProgramModelImpl.initCurrentProgramModel(getApplicationContext());
        CategoriesAndProgramsModelImpl.initCategoriesAndProgramModel(getApplicationContext());
        TopicsModelImpl.initTopicsModel(getApplicationContext());
    }
}
