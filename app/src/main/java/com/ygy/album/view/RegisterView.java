package com.ygy.album.view;

import com.ygy.album.bean.BaseBean;
import com.ygy.album.bean.ResponseBean;

/**
 * Created by Administrator on 2017/10/21.
 */

public interface RegisterView {
    void success(BaseBean bean);
    void error(Throwable e);
    void fail(String str);
    void countDown();
}
