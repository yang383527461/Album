package com.ygy.album.view;

import com.ygy.album.bean.BaseBean;
import com.ygy.album.bean.LoginBean;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface LoginView {
    void success(LoginBean loginBean);
    void fail(String str);
    void error(Throwable e);
    void initVideo();
}
