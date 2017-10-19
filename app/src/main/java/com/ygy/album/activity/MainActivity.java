package com.ygy.album.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ygy.album.R;
import com.ygy.album.adapter.MainPagerAdapter;
import com.ygy.album.base.BaseActivity;
import com.ygy.album.fragment.FollowFragment;
import com.ygy.album.fragment.HomeFragment;
import com.ygy.album.fragment.MyFragment;
import com.ygy.album.fragment.SearchFragment;
import com.ygy.album.utils.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.viewpager_mian)
    ViewPager viewpagerMain;
    @BindView(R.id.radbtn_home)
    RadioButton radbtnHome;
    @BindView(R.id.radbtn_search)
    RadioButton radbtnSearch;
    @BindView(R.id.radbtn_add)
    Button radbtnAdd;
    @BindView(R.id.radbtn_follow)
    RadioButton radbtnFollow;
    @BindView(R.id.radbtn_my)
    RadioButton radbtnMy;
    @BindView(R.id.radiogroup)
    RadioGroup radiogroup;


    public static int statusBarHeight;
    private Fragment mFragment;
    private List<Fragment> fragments;
    private MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        statusBarHeight = Util.getStatusBarHeight(this);

        initFragment();
        initViewPager();
    }

    private void initViewPager() {
        adapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        viewpagerMain.setAdapter(adapter);
        viewpagerMain.setCurrentItem(1);
        viewpagerMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radbtnHome.setChecked(true);
                        break;
                    case 1:
                        radbtnSearch.setChecked(true);
                        break;
                    case 2:
                        radbtnFollow.setChecked(true);
                        break;
                    case 3:
                        radbtnMy.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.radbtn_home:
                        viewpagerMain.setCurrentItem(0);
                        break;
                    case R.id.radbtn_search:
                        viewpagerMain.setCurrentItem(1);
                        break;
                    case R.id.radbtn_follow:
                        viewpagerMain.setCurrentItem(2);
                        break;
                    case R.id.radbtn_my:
                        viewpagerMain.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        mFragment = new HomeFragment();
        fragments.add(mFragment);
        mFragment = new SearchFragment();
        fragments.add(mFragment);
        mFragment = new FollowFragment();
        fragments.add(mFragment);
        mFragment = new MyFragment();
        fragments.add(mFragment);
    }


    @OnClick({R.id.radbtn_home, R.id.radbtn_search, R.id.radbtn_add, R.id.radbtn_follow, R.id.radbtn_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radbtn_home:
                break;
            case R.id.radbtn_search:
                break;
            case R.id.radbtn_add:
                break;
            case R.id.radbtn_follow:
                break;
            case R.id.radbtn_my:
                break;
        }
    }
}
