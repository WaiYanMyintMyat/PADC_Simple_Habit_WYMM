package com.wymm.padc_simple_habit_wymm.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gson.Gson;
import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.adapters.SessionsRecyclerAdapter;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wai Yan Myint Myat on 3/30/19.
 */
public class DetailActivity extends BaseActivity {

    @BindView(R.id.ctbl)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.tv_description)
    AppCompatTextView tvDescription;

    @BindView(R.id.rv_sessions)
    RecyclerView rvSession;

    //intent key
    private static final String CURRENT_PROGRAM_KEY = "current_program_key";
    //intent data
    private String currentProgramString;
    private CurrentProgramVO currentProgramVO;
    private Gson gson = new Gson();

    private SessionsRecyclerAdapter sessionsRecyclerAdapter;

    public static Intent newIntent(Context context,String currentProgramString) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(CURRENT_PROGRAM_KEY,currentProgramString);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        getIntentDataAndSetDataToUI();
        rvSession.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        sessionsRecyclerAdapter = new SessionsRecyclerAdapter();
        rvSession.setAdapter(sessionsRecyclerAdapter);
        sessionsRecyclerAdapter.setCurrentProgramVO(currentProgramVO.getSessions());
    }

    private void getIntentDataAndSetDataToUI() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            currentProgramString = extras.getString(CURRENT_PROGRAM_KEY);
            currentProgramVO = gson.fromJson(currentProgramString, CurrentProgramVO.class);

            collapsingToolbarLayout.setTitle(currentProgramVO.getTitle());
            tvDescription.setText(currentProgramVO.getDescription());
        }
    }
}
