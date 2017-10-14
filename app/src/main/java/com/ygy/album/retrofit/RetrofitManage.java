package com.ygy.album.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ygy.album.bean.LoginBean;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Administrator on 2017/10/13.
 */

public class RetrofitManage {
    private static String baseUrl = "http://116.196.109.110:8080/";

    private static Retrofit mRetrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    private static RetrofitService service = mRetrofit.create(RetrofitService.class);


    /**
     * 登录
     */
    public static Observable<LoginBean> login(String userName, String passwrod){
        return service.login(userName, passwrod);
    }
}
