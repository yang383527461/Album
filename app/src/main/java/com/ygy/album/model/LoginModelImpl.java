package com.ygy.album.model;

import com.ygy.album.bean.LoginBean;
import com.ygy.album.retrofit.RetrofitManage;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/13.
 */

public class LoginModelImpl implements LoginModel{

    private OnLoginListener mOnLoginListener;
    public LoginModelImpl(OnLoginListener onLoginListener) {
        this.mOnLoginListener = onLoginListener;
    }

    @Override
    public Subscription login(String name, String password) {
        Observable<LoginBean> observable = RetrofitManage.login(name, password);
        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mOnLoginListener.fail(e);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        mOnLoginListener.success(loginBean);
                    }
                });
        return subscription;
    }

    public interface OnLoginListener{
        void success(LoginBean loginBean);
        void fail(Throwable e);
    }
}
