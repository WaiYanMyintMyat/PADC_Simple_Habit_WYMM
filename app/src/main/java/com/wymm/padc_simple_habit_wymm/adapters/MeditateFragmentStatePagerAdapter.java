package com.wymm.padc_simple_habit_wymm.adapters;

import com.wymm.padc_simple_habit_wymm.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

/**
 * Created by Wai Yan Myint Myat on 3/28/19.
 */
public class MeditateFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public MeditateFragmentStatePagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void addFragments(String title, BaseFragment fragment){
        titleList.add(title);
        fragmentList.add(fragment);
    }
}
