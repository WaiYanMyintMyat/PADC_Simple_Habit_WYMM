package com.wymm.padc_simple_habit_wymm.views.holders;

import android.view.View;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class CategoriesAndProgramsRecyclerViewViewHolder extends BaseViewHolder<CategoriesAndProgramsVO> {
    @BindView(R.id.tv_title)
    public AppCompatTextView tvTitle;

    @BindView(R.id.rv)
    public RecyclerView rv;

    public CategoriesAndProgramsRecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
