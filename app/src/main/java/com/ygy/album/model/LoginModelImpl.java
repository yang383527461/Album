package com.ygy.album.model;

import com.ygy.album.bean.BaseBean;
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
        Observable<BaseBean<LoginBean>> observable = RetrofitManage.login(name, password);
        Subscription subscription = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean<LoginBean>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mOnLoginListener.error(e);
                    }

                    @Override
                    public void onNext(BaseBean<LoginBean> bean) {
                        if(bean.isSuccess()){
                            if(bean.getCode().equals("200")){
                                mOnLoginListener.success(bean.getData());
                            }else{
                                mOnLoginListener.fail("账户密码错误");
                            }
                        }else{
                            mOnLoginListener.error(new Throwable("异常"));
                        }
                    }
                });
        return subscription;
    }

    public interface OnLoginListener{
        void success(LoginBean loginBean);
        void error(Throwable e);
        void fail(String str);
    }
}
