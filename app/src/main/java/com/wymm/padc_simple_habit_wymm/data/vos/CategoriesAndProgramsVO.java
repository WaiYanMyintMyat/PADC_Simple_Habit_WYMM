package com.wymm.padc_simple_habit_wymm.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
@Entity(tableName = "categories_and_program")
public class CategoriesAndProgramsVO extends BaseVO{
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "category_id")
    @SerializedName("category-id")
    @Expose
    private String categoryId;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("programs")
    @Expose
    private List<ProgramVO> programs;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ProgramVO> getPrograms() {
        if (programs == null) {
            return new ArrayList<>();
        }
        return programs;
    }

    public void setPrograms(List<ProgramVO> programs) {
        this.programs = programs;
    }
}
