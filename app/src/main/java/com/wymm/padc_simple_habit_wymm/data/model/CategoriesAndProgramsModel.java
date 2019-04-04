package com.wymm.padc_simple_habit_wymm.data.model;


import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;

import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public interface CategoriesAndProgramsModel {
    void getCategoriesAndProgramsModel(CategoriesAndProgramsDelegateToView categoriesAndProgramsDelegateToView);

    interface CategoriesAndProgramsDelegateToView {
        void onCategoriesAndProgramsFetchFromNetwork (List<CategoriesAndProgramsVO> categoriesAndProgramsVOList);
        void onErrorCategoriesAndProgramsFetch (String message);
    }
}
