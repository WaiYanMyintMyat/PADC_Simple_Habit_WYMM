package com.wymm.padc_simple_habit_wymm.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.adapters.MeditateFragmentStatePagerAdapter;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramItemDelegate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 3/28/19.
 */
public class MeditateFragment extends BaseFragment {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private MeditateFragmentStatePagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meditate, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new MeditateFragmentStatePagerAdapter(getFragmentManager());
        adapter.addFragments("On The Go",new OnTheGoFragment());
        adapter.addFragments("Series",new SeriesFragment());
        adapter.addFragments("Teachers",new TeachersFragment());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.selectTab(tabLayout.getTabAt(1));
    }
}
