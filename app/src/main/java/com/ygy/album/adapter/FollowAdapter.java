package com.ygy.album.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ygy.album.R;
import com.ygy.album.bean.FollowBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public class FollowAdapter extends BaseQuickAdapter<FollowBean,BaseViewHolder>{

    private Context mContext;

    public FollowAdapter(Context context, @Nullable List<FollowBean> data) {
        super(R.layout.item_followlist,data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FollowBean item) {
        helper.setText(R.id.item_follow_name,item.getName());
        Glide.with(mContext).load(item.getImgUrl()).into((ImageView) helper.getView(R.id.item_follow_icon));
    }
}
