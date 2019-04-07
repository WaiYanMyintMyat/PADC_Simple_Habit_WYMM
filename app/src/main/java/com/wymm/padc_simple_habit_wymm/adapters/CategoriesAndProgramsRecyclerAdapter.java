package com.wymm.padc_simple_habit_wymm.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;
import com.wymm.padc_simple_habit_wymm.views.holders.CategoriesAndProgramsViewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class CategoriesAndProgramsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private CategoriesAndProgramsVO mCategoriesAndProgramsVO = new CategoriesAndProgramsVO();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_categories_and_programs, parent, false);
        return new CategoriesAndProgramsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((CategoriesAndProgramsViewHolder) holder).tvTitle.setText(mCategoriesAndProgramsVO.getPrograms().get(position).getTitle());
        if (mCategoriesAndProgramsVO.getPrograms().get(position).getAverageLengths().size() > 0) {
            ((CategoriesAndProgramsViewHolder) holder).tvMin.setText(String.valueOf(mCategoriesAndProgramsVO.getPrograms().get(position).getAverageLengths().get(0)).concat(" mins"));
        }
    }

    @Override
    public int getItemCount() {
        return mCategoriesAndProgramsVO.getPrograms().size();
    }

    public void setCategoriesAndProgramList(CategoriesAndProgramsVO categoriesAndProgramsVO) {
        mCategoriesAndProgramsVO = categoriesAndProgramsVO;
        notifyDataSetChanged();
    }
}
