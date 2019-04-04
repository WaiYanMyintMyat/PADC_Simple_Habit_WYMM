package com.wymm.padc_simple_habit_wymm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.data.vos.SessionVO;
import com.wymm.padc_simple_habit_wymm.views.holders.SessionsViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class SessionsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SessionVO> mSessionVOList = new ArrayList<>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_sessions,parent,false);
        return new SessionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((SessionsViewHolder)holder).tvSession.setText(mSessionVOList.get(position).getSessionId().concat("     "+mSessionVOList.get(position).getTitle()).concat("     "+mSessionVOList.get(position).getLengthInSeconds()));
    }

    @Override
    public int getItemCount() {
        return mSessionVOList.size();
    }

    public void setCurrentProgramVO(List<SessionVO> sessionVOList){
        mSessionVOList = sessionVOList;
    }
}
