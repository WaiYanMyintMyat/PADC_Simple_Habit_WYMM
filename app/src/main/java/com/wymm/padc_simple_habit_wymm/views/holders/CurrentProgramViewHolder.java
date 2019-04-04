package com.wymm.padc_simple_habit_wymm.views.holders;

import android.view.View;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramItemDelegate;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class CurrentProgramViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_button_title)
    public AppCompatTextView tvButtonTitle;

    @BindView(R.id.tv_min)
    public AppCompatTextView tvMin;

    public CurrentProgramViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
