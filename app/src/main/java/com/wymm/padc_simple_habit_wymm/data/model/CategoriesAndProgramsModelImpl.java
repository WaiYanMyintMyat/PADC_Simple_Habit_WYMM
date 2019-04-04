package com.wymm.padc_simple_habit_wymm.data.model;


import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;
import com.wymm.padc_simple_habit_wymm.delegates.CategoriesAndProgramsDelegate;
import com.wymm.padc_simple_habit_wymm.network.RetrofitDataAgent;
import com.wymm.padc_simple_habit_wymm.network.SimpleHabitApi;
import com.wymm.padc_simple_habit_wymm.network.SimpleHabitDataAgent;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class CategoriesAndProgramsModelImpl implements CategoriesAndProgramsModel{
    private static CategoriesAndProgramsModelImpl objInstance;
    private SimpleHabitDataAgent mDataAgent;

    public CategoriesAndProgramsModelImpl() {
        mDataAgent = RetrofitDataAgent.getObjInstance();
    }

    public static CategoriesAndProgramsModelImpl getObjInstance() {
        if (objInstance == null) {
            objInstance = new CategoriesAndProgramsModelImpl();
        }
        return objInstance;
    }

    @Override
    public void getCategoriesAndProgramsModel(final CategoriesAndProgramsDelegateToView categoriesAndProgramsDelegateToView) {
        mDataAgent.getCategoriesAndPrograms(1, CurrentProgramModelImpl.ACCESS_TOKEN,
                new CategoriesAndProgramsDelegate() {
                    @Override
                    public void onSuccess(List<CategoriesAndProgramsVO> categoriesAndProgramsVOList) {
                        categoriesAndProgramsDelegateToView.onCategoriesAndProgramsFetchFromNetwork(categoriesAndProgramsVOList);
                    }

                    @Override
                    public void onFail(String message) {
                        categoriesAndProgramsDelegateToView.onErrorCategoriesAndProgramsFetch(message);
                    }
                });
    }
}
