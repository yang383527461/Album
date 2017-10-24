package com.ygy.album.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import com.ygy.album.R;
import com.ygy.album.bean.MultipleItem;

import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */

public class MoreAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    private Context mContext;
    public MoreAdapter(Context context, List data) {
        super(data);
        this.mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, MultipleItem item) {
        switch (item.getItemType()){
            case MultipleItem.TEXT:
                helper.setText(R.id.tv_item_more_text,item.getContent());
                break;
            case MultipleItem.IMG_TEXT:

                break;
            case MultipleItem.SWITCH:
                break;
        }
    }
}
