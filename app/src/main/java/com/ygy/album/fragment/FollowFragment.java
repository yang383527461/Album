package com.ygy.album.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.*;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.ygy.album.R;
import com.ygy.album.activity.MainActivity;
import com.ygy.album.adapter.MainPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FollowFragment extends Fragment {


    @BindView(R.id.frame_follow)
    RelativeLayout frameFollow;
    Unbinder unbinder;
    @BindView(R.id.tab_follow)
    TabLayout tabFollow;
    @BindView(R.id.viewpager_follow)
    ViewPager viewpagerFollow;

    private List<Fragment> mFragments;
    private List<String> mTitles;
    private Fragment mFragment;
    private MainPagerAdapter adapter;

    public FollowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        unbinder = ButterKnife.bind(this, view);
        frameFollow.setPadding(0, MainActivity.statusBarHeight, 0, 0);
        initView();
        adapter = new MainPagerAdapter(getChildFragmentManager(), mFragments, mTitles);
        viewpagerFollow.setAdapter(adapter);
        tabFollow.setupWithViewPager(viewpagerFollow);
        return view;
    }

    private void initView() {
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();

        mFragment = new FollowListFragment();
        mFragments.add(mFragment);
        mFragment = new KeepFragment();
        mFragments.add(mFragment);

        mTitles.add("关注");
        mTitles.add("消息");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
