package com.ygy.album.presenter;

import com.ygy.album.bean.BaseBean;
import com.ygy.album.bean.ResponseBean;
import com.ygy.album.model.RegisterModel;
import com.ygy.album.model.RegisterModelImpl;
import com.ygy.album.view.RegisterView;

/**
 * Created by Administrator on 2017/10/21.
 */

public class RegisterPresenterImpl extends BasePresenter implements RegisterPresenter, RegisterModelImpl.OnRegisterListener {
    private RegisterModel mRegisterModel;
    private RegisterView mRegisterView;

    public RegisterPresenterImpl(RegisterView mRegisterView) {
        this.mRegisterView = mRegisterView;
        mRegisterModel = new RegisterModelImpl(this);
    }

    @Override
    public void register(String name, String userName, String password) {
        addSubscription(mRegisterModel.register(name, userName, password));
    }

    @Override
    public void unSub() {
        unSubscribe();
    }

    @Override
    public void success(BaseBean bean) {
        mRegisterView.success(bean);
    }

    @Override
    public void error(Throwable e) {
        mRegisterView.error(e);
    }

    @Override
    public void fail(String str) {
        mRegisterView.fail(str);
    }
}
