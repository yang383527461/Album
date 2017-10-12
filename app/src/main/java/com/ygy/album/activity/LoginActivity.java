package com.ygy.album.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ygy.album.R;
import com.ygy.album.base.BasaActivity;
import com.ygy.album.custView.CustVideoPlay;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BasaActivity {

    @BindView(R.id.custVideoView)
    CustVideoPlay custVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStatusBar();
        setFull();
        setContentView(R.layout.activity_login);
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

    }

    @Override
    protected void onRestart() {
        custVideoView.start();
        super.onRestart();
    }
}
