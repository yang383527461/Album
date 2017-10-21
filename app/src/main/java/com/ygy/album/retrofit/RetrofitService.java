package com.ygy.album.retrofit;

import com.ygy.album.bean.BaseBean;
import com.ygy.album.bean.LoginBean;
import com.ygy.album.bean.ResponseBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public interface RetrofitService {
    @GET("loginForApp")
    Observable<BaseBean<LoginBean>> login(@Query("username") String name, @Query("password") String password);

    @GET("register")
    Observable<ResponseBean> register(@Query("name") String name
                                        , @Query("userName") String userName
                                        , @Query("password") String password);

}
