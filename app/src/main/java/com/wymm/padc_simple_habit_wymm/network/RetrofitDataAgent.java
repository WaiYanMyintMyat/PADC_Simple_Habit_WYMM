package com.wymm.padc_simple_habit_wymm.network;

import com.google.gson.Gson;
import com.wymm.padc_simple_habit_wymm.delegates.CategoriesAndProgramsDelegate;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramDelegate;
import com.wymm.padc_simple_habit_wymm.delegates.TopicsDelegate;
import com.wymm.padc_simple_habit_wymm.network.responses.GetCategoriesAndProgramsResponse;
import com.wymm.padc_simple_habit_wymm.network.responses.GetCurrentProgramResponse;
import com.wymm.padc_simple_habit_wymm.network.responses.GetTopicsResponses;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class RetrofitDataAgent implements SimpleHabitDataAgent {
    private static RetrofitDataAgent objInstance;
    private SimpleHabitApi mSimpleHabitApi;
    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/simple-habits/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(okHttpClient)
                .build();

        mSimpleHabitApi = retrofit.create(SimpleHabitApi.class);
    }

    public static RetrofitDataAgent getObjInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void getCurrentProgram(int page, String accessToken, final CurrentProgramDelegate currentProgramDelegate) {
        Call<GetCurrentProgramResponse> call = mSimpleHabitApi.getCurrentProgram(accessToken, page);
        call.enqueue(new Callback<GetCurrentProgramResponse>() {
            @Override
            public void onResponse(Call<GetCurrentProgramResponse> call, Response<GetCurrentProgramResponse> response) {
                GetCurrentProgramResponse currentProgramResponse = response.body();
                if (currentProgramResponse != null) {
                    if (currentProgramResponse.isResponseSuccess()) {
                        currentProgramDelegate.onSuccess(currentProgramResponse.getCurrentProgram());
                    } else {
                        currentProgramDelegate.onFail(currentProgramResponse.getMessage());
                    }
                } else {
                    currentProgramDelegate.onFail("Response is null");
                }
            }

            @Override
            public void onFailure(Call<GetCurrentProgramResponse> call, Throwable t) {
                currentProgramDelegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void getCategoriesAndPrograms(int page, String accessToken, final CategoriesAndProgramsDelegate categoriesAndProgramsDelegate) {
        Call<GetCategoriesAndProgramsResponse> call = mSimpleHabitApi.getCategoriesAndPrograms(accessToken, page);
        call.enqueue(new Callback<GetCategoriesAndProgramsResponse>() {
            @Override
            public void onResponse(Call<GetCategoriesAndProgramsResponse> call, Response<GetCategoriesAndProgramsResponse> response) {
                GetCategoriesAndProgramsResponse categoriesAndProgramsResponse = response.body();
                if (categoriesAndProgramsResponse != null) {
                    if (categoriesAndProgramsResponse.isResponseSuccess()) {
                        categoriesAndProgramsDelegate.onSuccess(categoriesAndProgramsResponse.getCategoriesPrograms());
                    } else {
                        categoriesAndProgramsDelegate.onFail(categoriesAndProgramsResponse.getMessage());
                    }
                } else {
                    categoriesAndProgramsDelegate.onFail("Response is null");
                }
            }

            @Override
            public void onFailure(Call<GetCategoriesAndProgramsResponse> call, Throwable t) {
                categoriesAndProgramsDelegate.onFail(t.getMessage());
            }
        });
    }

    @Override
    public void getTopics(int page, String accessToken, final TopicsDelegate topicsDelegate) {
        Call<GetTopicsResponses> call = mSimpleHabitApi.getTopics(accessToken, page);
        call.enqueue(new Callback<GetTopicsResponses>() {
            @Override
            public void onResponse(Call<GetTopicsResponses> call, Response<GetTopicsResponses> response) {
                GetTopicsResponses topicsResponses = response.body();
                if (topicsResponses != null){
                    if (topicsResponses.isResponseSuccess()){
                        topicsDelegate.onSuccess(topicsResponses.getTopics());
                    }else{
                        topicsDelegate.onFail(topicsResponses.getMessage());
                    }
                }else{
                    topicsDelegate.onFail("Response is null");
                }
            }

            @Override
            public void onFailure(Call<GetTopicsResponses> call, Throwable t) {
                topicsDelegate.onFail(t.getMessage());
            }
        });
    }
}
