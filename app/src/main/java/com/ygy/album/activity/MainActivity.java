package com.ygy.album.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.ygy.album.R;
import com.ygy.album.base.BaseActivity;
import com.ygy.album.fragment.FollowFragment;
import com.ygy.album.fragment.HomeFragment;
import com.ygy.album.fragment.MyFragment;
import com.ygy.album.fragment.SearchFragment;
import com.ygy.album.utils.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.frame_mian)
    FrameLayout frameLayout;
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

    private Fragment mFragment;
    public static int statusBarHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        statusBarHeight = Util.getStatusBarHeight(this);

        SearchFragment mSearchFragment = new SearchFragment();
        change(mSearchFragment);
    }
    public void change(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_mian,fragment).commit();
    }

    @OnClick({R.id.radbtn_home, R.id.radbtn_search, R.id.radbtn_add, R.id.radbtn_follow, R.id.radbtn_my})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radbtn_home:
                mFragment = new HomeFragment();
                change(mFragment);
                break;
            case R.id.radbtn_search:
                mFragment = new SearchFragment();
                change(mFragment);
                break;
            case R.id.radbtn_add:
                break;
            case R.id.radbtn_follow:
                mFragment = new FollowFragment();
                change(mFragment);
                break;
            case R.id.radbtn_my:
                mFragment = new MyFragment();
                change(mFragment);
                break;
        }
    }
}
