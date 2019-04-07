package com.wymm.padc_simple_habit_wymm.network.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class GetCategoriesAndProgramsResponse extends BaseResponse{
    @SerializedName("page")
    @Expose
    private String page;
    @SerializedName("categoriesPrograms")
    @Expose
    private List<CategoriesAndProgramsVO> categoriesPrograms;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<CategoriesAndProgramsVO> getCategoriesPrograms() {
        if (categoriesPrograms == null){
            return new ArrayList<>();
        }
        return categoriesPrograms;
    }

    public void setCategoriesPrograms(List<CategoriesAndProgramsVO> categoriesPrograms) {
        this.categoriesPrograms = categoriesPrograms;
    }
}
