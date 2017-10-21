package com.ygy.album.presenter;

import com.ygy.album.bean.BaseBean;
import com.ygy.album.bean.LoginBean;
import com.ygy.album.model.LoginModel;
import com.ygy.album.model.LoginModelImpl;
import com.ygy.album.view.LoginView;

/**
 * Created by Administrator on 2017/10/13.
 */

public class LoginPresenterImpl extends BasePresenter implements LoginPresenter, LoginModelImpl.OnLoginListener{

    private LoginView mLoginView;
    private LoginModel mLoginModel;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginModel = new LoginModelImpl(this);
    }

    @Override
    public void login(String userName, String passwrod) {
        addSubscription(mLoginModel.login(userName, passwrod));
    }

    @Override
    public void unSub() {
        unSubscribe();
    }

    @Override
    public void success(LoginBean loginBean) {
        mLoginView.success(loginBean);
    }

    @Override
    public void error(Throwable e) {
        mLoginView.error(e);
    }

    @Override
    public void fail(String str) {
        mLoginView.fail(str);
    }
}
