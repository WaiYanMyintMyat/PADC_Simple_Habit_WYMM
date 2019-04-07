package com.wymm.padc_simple_habit_wymm.persistence.typeconverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wymm.padc_simple_habit_wymm.data.vos.ProgramVO;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

/**
 * Created by Wai Yan Myint Myat on 4/7/19.
 */
public class ListCategoriesAndProgramProgramVO {
    @TypeConverter
    public static String fromListToJson(List<ProgramVO> averageLength){
        return  new Gson().toJson(averageLength);
    }

    @TypeConverter
    public static List<ProgramVO> fromJsonToList(String jsonAverageLength){
        Type listType = new TypeToken<List<ProgramVO>>(){}.getType();
        return new Gson().fromJson(jsonAverageLength,listType);
    }
}
