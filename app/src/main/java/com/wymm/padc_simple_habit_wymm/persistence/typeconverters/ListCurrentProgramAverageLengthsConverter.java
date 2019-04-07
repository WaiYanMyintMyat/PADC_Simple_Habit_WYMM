package com.wymm.padc_simple_habit_wymm.persistence.typeconverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

/**
 * Created by Wai Yan Myint Myat on 4/6/19.
 */
public class ListCurrentProgramAverageLengthsConverter {

    @TypeConverter
    public static String fromListToJson(List<Integer> averageLength){
        return  new Gson().toJson(averageLength);
    }

    @TypeConverter
    public static List<Integer> fromJsonToList(String jsonAverageLength){
        Type listType = new TypeToken<List<Integer>>(){}.getType();
        return new Gson().fromJson(jsonAverageLength,listType);
    }
}
