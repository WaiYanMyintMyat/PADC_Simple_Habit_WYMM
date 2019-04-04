package com.wymm.padc_simple_habit_wymm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wymm.padc_simple_habit_wymm.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by Wai Yan Myint Myat on 3/28/19.
 */
public class MeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me,container,false);
        return view;
    }
}
