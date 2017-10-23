package com.ygy.album.model;

import com.ygy.album.bean.BaseBean;
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
        Observable<BaseBean> observable = RetrofitManage.register(name, userName, password);
        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mOnRegisterListener.error(e);
                    }

                    @Override
                    public void onNext(BaseBean bean) {
                        //mOnRegisterListener.success(responseBean);
                        if(bean.isSuccess()){
                            if(bean.getCode().equals("200")){
                                mOnRegisterListener.success(bean);
                            }else{
                                mOnRegisterListener.fail("用户名已存在");
                            }
                        }else{
                            mOnRegisterListener.error(new Throwable("异常"));
                        }
                    }
                });
        return subscription;
    }

    public interface OnRegisterListener{
        void success(BaseBean bean);
        void error(Throwable e);
        void fail(String str);
    }
}
