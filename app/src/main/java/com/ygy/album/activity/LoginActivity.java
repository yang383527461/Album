package com.ygy.album.activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ygy.album.R;
import com.ygy.album.base.BaseActivity;
import com.ygy.album.bean.BaseBean;
import com.ygy.album.bean.LoginBean;
import com.ygy.album.custView.CustVideoPlay;
import com.ygy.album.presenter.LoginPresenter;
import com.ygy.album.presenter.LoginPresenterImpl;
import com.ygy.album.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.custVideoView)
    CustVideoPlay custVideoView;
    @BindView(R.id.edt_login_name)
    EditText edtLoginName;
    @BindView(R.id.edt_login_pwd)
    EditText edtLoginPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_login_froget)
    TextView tvLoginFroget;
    @BindView(R.id.tv_login_register)
    TextView tvLoginRegister;
    @BindView(R.id.activityLayout)
    RelativeLayout activityLayout;
    @BindView(R.id.viewLayout)
    RelativeLayout viewLayout;

    private LoginPresenter mLoginPresenter;
    private boolean keyBoardShown = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBarBottom();

        setFull();
        setContentView(R.layout.activity_login);
      //  AndroidBug5497Workaround.assistActivity(this);
        ButterKnife.bind(this);
        //setupWindowAnimations();

        mLoginPresenter = new LoginPresenterImpl(this);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.login_background;
        custVideoView.setVideoURI(Uri.parse(uri));
        custVideoView.start();
        custVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                custVideoView.start();
            }
        });
        custVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                    @Override
                    public boolean onInfo(MediaPlayer mp, int what, int extra) {
                        if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                            custVideoView.setBackgroundColor(Color.TRANSPARENT);
                        return true;
                    }
                });
            }
        });
    }

    private void setupWindowAnimations() {
        Transition slideTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide_from_right);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }
    }

    @Override
    protected void onRestart() {
        custVideoView.start();
        super.onRestart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void success(LoginBean loginBean) {
        Toast.makeText(this, loginBean.getNick(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void error(Throwable e) {
        Toast.makeText(this, "异常1", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_login, R.id.tv_login_froget, R.id.tv_login_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String name = edtLoginName.getText().toString();
                String pwd = edtLoginPwd.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pwd.isEmpty()) {
                    Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                    return;
                }
                mLoginPresenter.login(name, pwd);
                break;
            case R.id.tv_login_froget:
                break;
            case R.id.tv_login_register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
        }
    }
}
