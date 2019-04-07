package com.wymm.padc_simple_habit_wymm.persistence.dao;

import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by Wai Yan Myint Myat on 4/7/19.
 */
@Dao
public interface CategoriesAndProgramsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertCategoriesAndProgramList(List<CategoriesAndProgramsVO> categoriesAndProgramsVOList);

    @Query("SELECT * FROM categories_and_program")
    List<CategoriesAndProgramsVO> selectCategoriesAndProgramList();
}
