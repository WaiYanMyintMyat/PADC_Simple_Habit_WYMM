package com.wymm.padc_simple_habit_wymm.network;

import com.wymm.padc_simple_habit_wymm.network.responses.GetCategoriesAndProgramsResponse;
import com.wymm.padc_simple_habit_wymm.network.responses.GetCurrentProgramResponse;
import com.wymm.padc_simple_habit_wymm.network.responses.GetTopicsResponses;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public interface SimpleHabitApi {
    @FormUrlEncoded
    @POST("getCurrentProgram.php")
    Call<GetCurrentProgramResponse> getCurrentProgram (@Field("access_token") String accessToken,
                                                       @Field("page") int page);

    @FormUrlEncoded
    @POST("getCategoriesPrograms.php")
    Call<GetCategoriesAndProgramsResponse> getCategoriesAndPrograms (@Field("access_token") String accessToken,
                                                                     @Field("page") int page);

    @FormUrlEncoded
    @POST("getTopics.php")
    Call<GetTopicsResponses> getTopics (@Field("access_token") String accessToken,
                                        @Field("page") int page);
}
