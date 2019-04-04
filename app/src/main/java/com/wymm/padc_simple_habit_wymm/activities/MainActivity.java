package com.wymm.padc_simple_habit_wymm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.wymm.padc_simple_habit_wymm.R;
import com.wymm.padc_simple_habit_wymm.data.vos.CurrentProgramVO;
import com.wymm.padc_simple_habit_wymm.delegates.CurrentProgramItemDelegate;
import com.wymm.padc_simple_habit_wymm.fragments.MeFragment;
import com.wymm.padc_simple_habit_wymm.fragments.MeditateFragment;
import com.wymm.padc_simple_habit_wymm.fragments.MoreFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements CurrentProgramItemDelegate {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bnv)
    BottomNavigationView bnv;
    @BindView(R.id.fl)
    FrameLayout fl;
    private FragmentManager fragmentManager;
    private Fragment chooseFragment;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gson = new Gson();
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        setSupportActionBar(toolbar);
        chooseFragment = new MeditateFragment();
        selectedMenuMeditate(chooseFragment);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_meditate:
                        chooseFragment = new MeditateFragment();
                        selectedMenuMeditate(chooseFragment);
                        break;
                    case R.id.menu_me:
                        chooseFragment = new MeFragment();
                        selectedMenuMe(chooseFragment);
                        break;
                    case R.id.menu_more:
                        chooseFragment = new MoreFragment();
                        selectedMenuMore(chooseFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void selectedMenuMeditate(Fragment chooseFragment) {
        setToolbarTitle(getResources().getString(R.string.meditate));
        fragmentManager.beginTransaction().replace(R.id.fl,chooseFragment).commit();
    }

    private void selectedMenuMe(Fragment chooseFragment) {
        setToolbarTitle(getResources().getString(R.string.me));
        fragmentManager.beginTransaction().replace(R.id.fl,chooseFragment).commit();
    }

    private void selectedMenuMore(Fragment chooseFragment) {
        setToolbarTitle(getResources().getString(R.string.more));
        fragmentManager.beginTransaction().replace(R.id.fl,chooseFragment).commit();
    }

    private void setToolbarTitle(String toolbarTitle) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(toolbarTitle);
        }
    }

    @Override
    public void onTapCurrentProgram(CurrentProgramVO currentProgramVO) {
        Intent intent = DetailActivity.newIntent(getApplicationContext(),gson.toJson(currentProgramVO));
        startActivity(intent);
    }
}
