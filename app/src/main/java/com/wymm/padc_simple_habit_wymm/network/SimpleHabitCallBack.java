package com.wymm.padc_simple_habit_wymm.network;

import com.wymm.padc_simple_habit_wymm.delegates.BaseNetworkDelegate;
import com.wymm.padc_simple_habit_wymm.network.responses.BaseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Wai Yan Myint Myat on 4/5/19.
 */
public abstract class SimpleHabitCallBack<T extends BaseResponse,W extends BaseNetworkDelegate> implements Callback<T> {
    W networkDelegate;

    public SimpleHabitCallBack(W networkDelegate) {
        this.networkDelegate = networkDelegate;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        T simpleHabitResponse = response.body();
        if (simpleHabitResponse == null){
            networkDelegate.onFail("Response is null.");
        } else {
            if(!simpleHabitResponse.isResponseSuccess()){
                networkDelegate.onFail(simpleHabitResponse.getMessage());
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        networkDelegate.onFail(t.getMessage());
    }
}
