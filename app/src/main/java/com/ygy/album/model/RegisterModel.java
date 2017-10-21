package com.ygy.album.model;

import rx.Subscription;

/**
 * Created by Administrator on 2017/10/21.
 */

public interface RegisterModel {
    Subscription register(String name, String userName, String password);
}
