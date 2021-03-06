package com.ygy.album.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.ygy.album.R;
import com.ygy.album.utils.PreferenceUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    @BindView(R.id.img_my_icon)
    RoundedImageView imgMyIcon;
    @BindView(R.id.tv_my_name)
    TextView tvMyName;
    @BindView(R.id.tv_my_follow)
    TextView tvMyFollow;
    @BindView(R.id.tv_my_fans)
    TextView tvMyFans;
    @BindView(R.id.view_top)
    RelativeLayout viewTop;
    //    @BindView(R.id.viewpager_my)
//    ViewPager viewpagerMy;
    Unbinder unbinder;
    @BindView(R.id.img_my_more)
    ImageView imgMyMore;
    @BindView(R.id.framelayout_my)
    FrameLayout framelayoutMy;

    public MyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        getFragmentManager().beginTransaction().replace(R.id.framelayout_my,new FindFragment());
        if (!TextUtils.isEmpty(PreferenceUtil.getStringValue(getActivity(), "name"))) {
            tvMyName.setText(PreferenceUtil.getStringValue(getActivity(), "name"));
            Glide.with(getActivity()).load(PreferenceUtil.getStringValue(getActivity(), "icon")).centerCrop().into(imgMyIcon);
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.img_my_more)
    public void onViewClicked() {

    }
}
