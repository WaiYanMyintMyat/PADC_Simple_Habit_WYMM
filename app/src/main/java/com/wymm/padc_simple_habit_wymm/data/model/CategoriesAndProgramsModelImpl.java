package com.wymm.padc_simple_habit_wymm.data.model;


import android.content.Context;
import android.util.Log;

import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;
import com.wymm.padc_simple_habit_wymm.delegates.CategoriesAndProgramsDelegate;
import com.wymm.padc_simple_habit_wymm.persistence.typeconverters.ListCategoriesAndProgramProgramVO;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class CategoriesAndProgramsModelImpl extends BaseModel implements CategoriesAndProgramsModel {
    private static CategoriesAndProgramsModelImpl objInstance;

    private CategoriesAndProgramsModelImpl(Context context) {
        super(context);
    }

    public static void initCategoriesAndProgramModel(Context context) {
        objInstance = new CategoriesAndProgramsModelImpl(context);
    }

    public static CategoriesAndProgramsModelImpl getObjInstance() {
        if (objInstance == null) {
            throw new RuntimeException("CategoriesAndProgramsModel shold have been initaialized before using it.");
        }
        return objInstance;
    }

    @Override
    public List<CategoriesAndProgramsVO> getCategoriesAndProgramsModel(final CategoriesAndProgramsDelegateToView categoriesAndProgramsDelegateToView) {
        if (mSimpleHabitDB.isEmptyCategoriesAndProgramVOTable()) {
            mDataAgent.getCategoriesAndPrograms(1, CurrentProgramModelImpl.ACCESS_TOKEN,
                    new CategoriesAndProgramsDelegate() {
                        @Override
                        public void onSuccess(List<CategoriesAndProgramsVO> categoriesAndProgramsVOList) {
                            long[] categoriesAndProgramsId = mSimpleHabitDB.categoriesAndProgramsDao().insertCategoriesAndProgramList(categoriesAndProgramsVOList);
                            Log.d("categoriesAndProgramsId", categoriesAndProgramsId[0] + "");
                            List<CategoriesAndProgramsVO> categoriesAndProgramsVOListFromDB = mSimpleHabitDB.categoriesAndProgramsDao().selectCategoriesAndProgramList();
                            categoriesAndProgramsDelegateToView.onCategoriesAndProgramsFetchFromNetwork(categoriesAndProgramsVOListFromDB);
                        }

                        @Override
                        public void onFail(String message) {
                            categoriesAndProgramsDelegateToView.onErrorCategoriesAndProgramsFetch(message);
                        }
                    });
        } else {
            List<CategoriesAndProgramsVO> categoriesAndProgramsVOList = mSimpleHabitDB.categoriesAndProgramsDao().selectCategoriesAndProgramList();
            return categoriesAndProgramsVOList;
        }
        return null;
    }
}
