package com.ygy.album.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ygy.album.R;
import com.ygy.album.custView.CustVideoPlay;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.img_register_bck)
    ImageView imgBackground;
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

        // 创建EventHandler对象
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                mHandler.sendMessage(msg);
            }
        };

        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);

    }

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            if(result == SMSSDK.RESULT_COMPLETE){
                if(event == SMSSDK.EVENT_GET_VERIFICATION_CODE){
                    Toast.makeText(RegisterActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                    getdownTime();
                }else if(event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE){
                    Toast.makeText(RegisterActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
                }
            }else {
                int status = 0;
                try {
                    ((Throwable) data).printStackTrace();
                    Throwable throwable = (Throwable) data;

                    JSONObject object = new JSONObject(throwable.getMessage());
                    String des = object.optString("detail");
                    status = object.optInt("status");
                    if (!TextUtils.isEmpty(des)) {
                        Toast.makeText(RegisterActivity.this, des, Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    SMSLog.getInstance().w(e);
                }
            }
        }
    };

    public void getdownTime(){
        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                btnRegisterCode.setText(millisUntilFinished/1000 +" s");
            }

            @Override
            public void onFinish() {
                btnRegisterCode.setText("验证码");
            }
        }.start();
    }

    @Override
    protected void onRestart() {
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
                if(!btnRegisterCode.getText().toString().trim().equals("验证码")){
                    Toast.makeText(this, "请等待倒计时再次收取验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                SMSSDK.getVerificationCode("86", phone);
                break;
            case R.id.btn_login:
                if (TextUtils.isEmpty(edtRegisterPwd.getText().toString().trim())
                        ||TextUtils.isEmpty(edtRegisterPwd2.getText().toString().trim())){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                String code = tvRegisterCode.getText().toString().trim();
                SMSSDK.submitVerificationCode("86", phone, code);
                break;
        }
    }
}
