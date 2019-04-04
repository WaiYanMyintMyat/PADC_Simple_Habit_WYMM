package com.wymm.padc_simple_habit_wymm.views.holders;

import android.view.View;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class CurrentProgramViewHolder extends BaseViewHolder<CurrentProgramVO> {
    @BindView(R.id.tv_button_title)
    public AppCompatTextView tvButtonTitle;

    @BindView(R.id.tv_min)
    public AppCompatTextView tvMin;

    public CurrentProgramViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
