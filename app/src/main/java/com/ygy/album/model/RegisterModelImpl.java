package com.ygy.album.model;

import com.ygy.album.bean.ResponseBean;
import com.ygy.album.retrofit.RetrofitManage;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/21.
 */

public class RegisterModelImpl implements RegisterModel {
    private OnRegisterListener mOnRegisterListener;

    public RegisterModelImpl(OnRegisterListener onRegisterListener) {
        this.mOnRegisterListener = onRegisterListener;
    }

    @Override
    public Subscription register(String name, String userName, String password) {
        Observable<ResponseBean> observable = RetrofitManage.register(name, userName, password);
        Subscription subscription = observable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mOnRegisterListener.fail(e);
                    }

                    @Override
                    public void onNext(ResponseBean responseBean) {
                        mOnRegisterListener.success(responseBean);
                    }
                });
        return subscription;
    }

    public interface OnRegisterListener{
        void success(ResponseBean responseBean);
        void fail(Throwable e);
    }
}
