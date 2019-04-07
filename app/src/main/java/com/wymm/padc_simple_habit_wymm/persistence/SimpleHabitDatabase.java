package com.wymm.padc_simple_habit_wymm.persistence;

import android.content.Context;

import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;
import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;
import com.wymm.padc_simple_habit_wymm.persistence.dao.CategoriesAndProgramsDao;
import com.wymm.padc_simple_habit_wymm.persistence.dao.CurrentProgramDao;
import com.wymm.padc_simple_habit_wymm.persistence.dao.TopicsDao;
import com.wymm.padc_simple_habit_wymm.persistence.typeconverters.ListCategoriesAndProgramProgramVO;
import com.wymm.padc_simple_habit_wymm.persistence.typeconverters.ListCurrentProgramAverageLengthsConverter;
import com.wymm.padc_simple_habit_wymm.persistence.typeconverters.ListCurrentProgramSession;

import java.util.List;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Created by Wai Yan Myint Myat on 4/6/19.
 */
@Database(entities = {CurrentProgramVO.class, CategoriesAndProgramsVO.class, TopicsVO.class}, version = 1)
@TypeConverters({ListCurrentProgramAverageLengthsConverter.class, ListCurrentProgramSession.class, ListCategoriesAndProgramProgramVO.class})
public abstract class SimpleHabitDatabase extends RoomDatabase {
    private static SimpleHabitDatabase INSTANCE;

    public static SimpleHabitDatabase getINSTANCE(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, SimpleHabitDatabase.class, "SimpleDatabase.DB")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public abstract CurrentProgramDao currentProgramDao();

    public abstract CategoriesAndProgramsDao categoriesAndProgramsDao();

    public abstract TopicsDao topicsDao();

    public boolean isEmptyCurrentProgramVoTable() {
        CurrentProgramVO currentProgramVO = currentProgramDao().getCurrentProgram();
        return currentProgramVO == null;
    }

    public boolean isEmptyCategoriesAndProgramVOTable() {
        List<CategoriesAndProgramsVO> categoriesAndProgramsVOList = categoriesAndProgramsDao().selectCategoriesAndProgramList();
        return categoriesAndProgramsVOList == null || categoriesAndProgramsVOList.size() == 0;
    }

    public boolean isEmptyTopicVOTable() {
        List<TopicsVO> topicsVOList = topicsDao().selectTopicsList();
        return topicsVOList == null || topicsVOList.size() == 0;
    }
}
