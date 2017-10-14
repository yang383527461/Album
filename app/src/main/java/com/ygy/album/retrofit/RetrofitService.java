package com.ygy.album.retrofit;

import com.ygy.album.bean.LoginBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface RetrofitService {
    @GET("login")
    Observable<LoginBean> login(@Query("userName") String name, @Query("password") String password);

}
