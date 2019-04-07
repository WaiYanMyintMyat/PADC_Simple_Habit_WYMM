package com.wymm.padc_simple_habit_wymm.persistence.typeconverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wymm.padc_simple_habit_wymm.data.vos.SessionVO;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

/**
 * Created by Wai Yan Myint Myat on 4/6/19.
 */
public class ListCurrentProgramSession {
    @TypeConverter
    public static String fromListToJson(List<SessionVO> averageLength){
        return  new Gson().toJson(averageLength);
    }

    @TypeConverter
    public static List<SessionVO> fromJsonToList(String jsonAverageLength){
        Type listType = new TypeToken<List<SessionVO>>(){}.getType();
        return new Gson().fromJson(jsonAverageLength,listType);
    }
}
