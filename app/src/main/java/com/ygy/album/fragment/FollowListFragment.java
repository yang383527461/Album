package com.ygy.album.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ygy.album.R;
import com.ygy.album.adapter.FollowAdapter;
import com.ygy.album.bean.FollowBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FollowListFragment extends Fragment {

    @BindView(R.id.recycle_follow)
    RecyclerView recycleFollow;
    Unbinder unbinder;

    private FollowAdapter adapter;
    private List<FollowBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        recycleFollow.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FollowAdapter(getActivity(),list);

        recycleFollow.setAdapter(adapter);
        return view;
    }

    private void initData() {
        list = new ArrayList<>();
        FollowBean f = new FollowBean("http://img4.imgtn.bdimg.com/it/u=1762973822,121126736&fm=27&gp=0.jpg","123");
        list.add(f);
        FollowBean f1 = new FollowBean("http://img4.imgtn.bdimg.com/it/u=4250696313,681315509&fm=27&gp=0.jpg","456");
        list.add(f1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
