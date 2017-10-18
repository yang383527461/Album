package com.ygy.album.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ygy.album.R;
import com.ygy.album.custView.CustVideoPlay;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.custVideoView)
    CustVideoPlay custVideoView;
    @BindView(R.id.edt_register_name)
    EditText edtRegisterName;
    @BindView(R.id.btn_register_code)
    Button btnRegisterCode;
    @BindView(R.id.edt_register_pwd)
    EditText edtRegisterPwd;
    @BindView(R.id.edt_register_pwd2)
    EditText edtRegisterPwd2;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_register_code)
    EditText tvRegisterCode;
    private EventHandler eventHandler;
    private int countdown = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        String uri = "android.resource://" + getPackageName() + "/" + R.raw.login_background;
        custVideoView.setVideoURI(Uri.parse(uri));
        custVideoView.start();
        custVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                custVideoView.start();
            }
        });
        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable) data;
                    final String msg = throwable.getMessage();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                            Log.d("asd", msg);
                        }
                    }).start();

                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 处理你自己的逻辑
                        Log.d("asd", "发送成功");
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    while (countdown >= 0) {
                                        Thread.sleep(1000);
                                        Log.d("asd", countdown-- + "s");

                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();

                    } else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        Log.d("asd", "Success");
                    }
                }
            }
        };

        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (countdown >= 0) {
                        Thread.sleep(1000);
                        Log.d("asd", countdown-- + "s");
                        btnRegisterCode.setText("已发送");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    protected void onRestart() {
        custVideoView.start();
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterEventHandler(eventHandler);
    }

    @OnClick({R.id.btn_register_code, R.id.btn_login})
    public void onViewClicked(View view) {
        String phone = edtRegisterName.getText().toString().trim();
        switch (view.getId()) {
            case R.id.btn_register_code:
                SMSSDK.getVerificationCode("86", phone);
                break;
            case R.id.btn_login:
                String code = tvRegisterCode.getText().toString().trim();
                SMSSDK.submitVerificationCode("86", phone, code);
                break;
        }
    }
}
