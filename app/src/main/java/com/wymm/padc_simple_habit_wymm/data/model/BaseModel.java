package com.wymm.padc_simple_habit_wymm.data.model;

import android.content.Context;

import com.wymm.padc_simple_habit_wymm.network.RetrofitDataAgent;
import com.wymm.padc_simple_habit_wymm.network.SimpleHabitDataAgent;
import com.wymm.padc_simple_habit_wymm.persistence.SimpleHabitDatabase;

/**
 * Created by Wai Yan Myint Myat on 4/6/19.
 */
public class BaseModel {
    protected SimpleHabitDataAgent mDataAgent;
    protected SimpleHabitDatabase mSimpleHabitDB;

    public BaseModel(Context context){
        mDataAgent = RetrofitDataAgent.getObjInstance();
        mSimpleHabitDB = SimpleHabitDatabase.getINSTANCE(context);
    }
}
