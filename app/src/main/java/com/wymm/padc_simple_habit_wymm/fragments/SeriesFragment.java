package com.wymm.padc_simple_habit_wymm.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.adapters.SeriesRecyclerAdapter;
import com.wymm.padc_simple_habit_wymm.data.model.CategoriesAndProgramsModel;
import com.wymm.padc_simple_habit_wymm.data.model.CategoriesAndProgramsModelImpl;
import com.wymm.padc_simple_habit_wymm.data.model.CurrentProgramModel;
import com.wymm.padc_simple_habit_wymm.data.model.CurrentProgramModelImpl;
import com.wymm.padc_simple_habit_wymm.data.model.TopicsModel;
import com.wymm.padc_simple_habit_wymm.data.model.TopicsModelImpl;
import com.wymm.padc_simple_habit_wymm.data.vos.CategoriesAndProgramsVO;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;
import com.wymm.padc_simple_habit_wymm.data.vos.TopicsVO;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramItemDelegate;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 3/28/19.
 */
public class SeriesFragment extends BaseFragment {
    @BindView(R.id.rv)
    RecyclerView rv;
    private SeriesRecyclerAdapter seriesRecyclerAdapter;
    private CurrentProgramModelImpl mCurrentProgramImpl;
    private CategoriesAndProgramsModelImpl mCategoriesAndProgramsImpl;
    private TopicsModelImpl mTopicsModelImpl;

    private CurrentProgramItemDelegate currentProgramItemDelegate;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        currentProgramItemDelegate = (CurrentProgramItemDelegate) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCurrentProgramImpl = CurrentProgramModelImpl.getObjInstance();
        mCategoriesAndProgramsImpl = CategoriesAndProgramsModelImpl.getObjInstance();
        mTopicsModelImpl = TopicsModelImpl.getObjInstance();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        seriesRecyclerAdapter = new SeriesRecyclerAdapter(currentProgramItemDelegate);
        rv.setAdapter(seriesRecyclerAdapter);
        getCurrentProgramData();
        getCategoriesAndPrograms();
        getTopics();
    }

    private void getCurrentProgramData() {
        CurrentProgramVO currentProgramVO = mCurrentProgramImpl.getCurrentProgramVO(new CurrentProgramModel.CurrentProgramDelegateToView() {
            @Override
            public void onCurrentProgramFetchFromNetwork(CurrentProgramVO currentProgramVO) {
                seriesRecyclerAdapter.setCurrentProgramData(currentProgramVO);
            }

            @Override
            public void onErrorCurrentProgramFetch(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        if (currentProgramVO != null) {
            seriesRecyclerAdapter.setCurrentProgramData(currentProgramVO);
        }
    }

    private void getCategoriesAndPrograms() {
        List<CategoriesAndProgramsVO> categoriesAndProgramsVOList = mCategoriesAndProgramsImpl.getCategoriesAndProgramsModel(new CategoriesAndProgramsModel.CategoriesAndProgramsDelegateToView() {
            @Override
            public void onCategoriesAndProgramsFetchFromNetwork(List<CategoriesAndProgramsVO> categoriesAndProgramsVOList) {
                seriesRecyclerAdapter.setCategoriesAndProgramsList(categoriesAndProgramsVOList);
            }

            @Override
            public void onErrorCategoriesAndProgramsFetch(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        if (categoriesAndProgramsVOList != null) {
            seriesRecyclerAdapter.setCategoriesAndProgramsList(categoriesAndProgramsVOList);
        }
    }

    private void getTopics() {
        List<TopicsVO> topicsVOList = mTopicsModelImpl.getTopicsList(new TopicsModel.TopicsDelegateToView() {
            @Override
            public void onTopicsFetchFromNetwork(List<TopicsVO> topicsVOList) {
                seriesRecyclerAdapter.setTopicsList(topicsVOList);
            }

            @Override
            public void onErrorTopicsFetch(String message) {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                ;
            }
        });

        if (topicsVOList != null) {
            seriesRecyclerAdapter.setTopicsList(topicsVOList);
        }
    }

}
