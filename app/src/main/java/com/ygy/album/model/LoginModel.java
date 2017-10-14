package com.ygy.album.model;

import rx.Subscription;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface LoginModel {
    Subscription login(String name, String password);
}
