package com.wymm.padc_simple_habit_wymm.views.holders;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 4/4/19.
 */
public abstract class BaseViewHolder<VO> extends RecyclerView.ViewHolder {
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
