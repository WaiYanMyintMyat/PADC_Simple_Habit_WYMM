package com.wymm.padc_simple_habit_wymm.views.holders;

import android.view.View;

import com.wymm.padc_simple_habit_wymm.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class SessionsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_session)
    public AppCompatTextView tvSession;

    public SessionsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
