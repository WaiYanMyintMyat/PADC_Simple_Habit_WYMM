package com.wymm.padc_simple_habit_wymm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;
import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramItemDelegate;
import com.wymm.padc_simple_habit_wymm.views.holders.CategoriesAndProgramsRecyclerViewViewHolder;
import com.wymm.padc_simple_habit_wymm.views.holders.CurrentProgramViewHolder;
import com.wymm.padc_simple_habit_wymm.views.holders.TopicsViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Wai Yan Myint Myat on 3/29/19.
 */
public class SeriesRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int CURRENT_PROGRAM_VIEW = 0;
    private static final int CATEGORIES_AND_PROGRAMS_RECYCLER_VIEW = 1;
    private static final int TOPICS_VIEW = 2;
    private Context context;
    private CurrentProgramVO mCurrentProgramVO = new CurrentProgramVO();
    private CategoriesAndProgramsRecyclerAdapter categoriesAndProgramsRecyclerAdapter;
    private List<CategoriesAndProgramsVO> mCategoriesAndProgramsList = new ArrayList<>();
    private List<TopicsVO> mTopicsList = new ArrayList<>();

    private CurrentProgramItemDelegate mCurrentProgramItemDelegate;

    public SeriesRecyclerAdapter(CurrentProgramItemDelegate currentProgramItemDelegate) {
        mCurrentProgramItemDelegate = currentProgramItemDelegate;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case CURRENT_PROGRAM_VIEW:
                View currentProgramView = layoutInflater.inflate(R.layout.view_item_current_program, parent, false);
                return new CurrentProgramViewHolder(currentProgramView);
            case CATEGORIES_AND_PROGRAMS_RECYCLER_VIEW:
                View categoriesAndProgramsRecyclerView = layoutInflater.inflate(R.layout.view_item_categories_and_programs_recycler_view, parent, false);
                return new CategoriesAndProgramsRecyclerViewViewHolder(categoriesAndProgramsRecyclerView);
            case TOPICS_VIEW:
                View topicsView = layoutInflater.inflate(R.layout.view_item_topics, parent, false);
                return new TopicsViewHolder(topicsView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case CURRENT_PROGRAM_VIEW:
                ((CurrentProgramViewHolder) holder).tvButtonTitle.setText(mCurrentProgramVO.getTitle());
                if (mCurrentProgramVO.getAverageLengths().size() > 0) {
                    ((CurrentProgramViewHolder) holder).tvMin.setText(String.valueOf(mCurrentProgramVO.getAverageLengths().get(0)).concat(" mins"));
                }

                ((CurrentProgramViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCurrentProgramItemDelegate.onTapCurrentProgram(mCurrentProgramVO);
                    }
                });
                break;
            case CATEGORIES_AND_PROGRAMS_RECYCLER_VIEW:
                categoriesAndProgramsRecyclerAdapter = new CategoriesAndProgramsRecyclerAdapter();
                ((CategoriesAndProgramsRecyclerViewViewHolder) holder).rv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                ((CategoriesAndProgramsRecyclerViewViewHolder) holder).rv.setAdapter(categoriesAndProgramsRecyclerAdapter);
                if (mCategoriesAndProgramsList.size() > 0) {
                    ((CategoriesAndProgramsRecyclerViewViewHolder) holder).tvTitle.setText(mCategoriesAndProgramsList.get(position - 1).getTitle());
                    categoriesAndProgramsRecyclerAdapter.setCategoriesAndProgramList(mCategoriesAndProgramsList.get(position - 1));
                }
                break;
            case TOPICS_VIEW:
                if (mTopicsList.size() > 0) {
                    if (position == 3) {
                        ((TopicsViewHolder) holder).tvTopic.setVisibility(View.VISIBLE);
                    } else {
                        ((TopicsViewHolder) holder).tvTopic.setVisibility(View.GONE);
                    }
                    ((TopicsViewHolder) holder).tvTopicName.setText(mTopicsList.get(position - 3).getTopicName());
                    ((TopicsViewHolder) holder).tvTopicDesc.setText(mTopicsList.get(position - 3).getTopicDesc());
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return CURRENT_PROGRAM_VIEW;
            case 1:
                return CATEGORIES_AND_PROGRAMS_RECYCLER_VIEW;
            case 2:
                return CATEGORIES_AND_PROGRAMS_RECYCLER_VIEW;
            case 3:
                return TOPICS_VIEW;
            default:
                return TOPICS_VIEW;
        }
    }

    public void setCurrentProgramData(CurrentProgramVO currentProgramVO) {
        mCurrentProgramVO = currentProgramVO;
        notifyDataSetChanged();
    }

    public void setCategoriesAndProgramsList(List<CategoriesAndProgramsVO> categoriesAndProgramsList) {
        mCategoriesAndProgramsList = categoriesAndProgramsList;
    }

    public void setTopicsList(List<TopicsVO> topicsList) {
        mTopicsList = topicsList;
    }
}
