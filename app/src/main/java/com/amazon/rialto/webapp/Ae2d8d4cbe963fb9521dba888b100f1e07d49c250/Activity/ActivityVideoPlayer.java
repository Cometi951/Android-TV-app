package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity;

import static android.view.KeyEvent.KEYCODE_MEDIA_REWIND;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.squareup.picasso.Picasso;

import fr.bmartel.youtubetv.YoutubeTvView;

public class ActivityVideoPlayer extends AppCompatActivity {

    SeekBar sbVideoPlayer;
    TextView tvVideoPlayerStartTime, tvVideoPlayerEndTime, tvVideoPlayerSetForwardMultiplier;
    ImageView img_video_player, img_play_pause;
    RelativeLayout rlVideoPlayerNativePlayerControls;
    FrameLayout animationView_forward, animationView_backward;
    double videoDuration = 0;
    String videoImage, videoTitle;
    float currentTime;
    private YoutubeTvView mYoutubeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        videoImage = getIntent().getStringExtra("videoImage");
        videoTitle = getIntent().getStringExtra("videoTitle");
        sbVideoPlayer = findViewById(R.id.sbVideoPlayer);
        animationView_forward = findViewById(R.id.animationView_forward);
        animationView_backward = findViewById(R.id.animationView_backward);
        img_video_player = findViewById(R.id.img_video_player);
        img_play_pause = findViewById(R.id.img_play_pause);
        tvVideoPlayerStartTime = findViewById(R.id.tvVideoPlayerStartTime);
        tvVideoPlayerSetForwardMultiplier = findViewById(R.id.tvVideoPlayerSetForwardMultiplier);
        rlVideoPlayerNativePlayerControls = findViewById(R.id.rlVideoPlayerNativePlayerControls);
        tvVideoPlayerEndTime = findViewById(R.id.tvVideoPlayerEndTime);
        mYoutubeView = findViewById(R.id.youtube_video);
        mYoutubeView.playVideo(getIntent().getStringExtra("videoId"));
        tvVideoPlayerSetForwardMultiplier.setText(videoTitle);
        Picasso.with(this).load(videoImage).into(img_video_player);

        mYoutubeView.setOnProgressUpdateListener(currentTimes -> runOnUiThread(() -> {
            if (videoDuration == 0) {
                rlVideoPlayerNativePlayerControls.setVisibility(View.GONE);
                videoDuration = mYoutubeView.getDuration();
                tvVideoPlayerEndTime.setText(String.format("%02d", (int) videoDuration / 60) + ":" + String.format("%02d", (int) videoDuration % 60));
            }
            currentTime = currentTimes;
            tvVideoPlayerStartTime.setText(String.format("%02d", (int) currentTimes / 60) + ":" + String.format("%02d", (int) currentTimes % 60));
            sbVideoPlayer.setProgress((int) ((currentTimes / videoDuration) * 100));

        }));
        mYoutubeView.start();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mYoutubeView.closePlayer();
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KEYCODE_MEDIA_REWIND) {

            mYoutubeView.moveBackward(10);
            tvVideoPlayerStartTime.setText(String.format("%02d", (int) currentTime - 10));
            animationView_backward.setVisibility(View.VISIBLE);
            rlVideoPlayerNativePlayerControls.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationView_backward.setVisibility(View.GONE);
                    rlVideoPlayerNativePlayerControls.setVisibility(View.GONE);
                }
            }, 1200);

        } else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {

            mYoutubeView.moveBackward(10);
            tvVideoPlayerStartTime.setText(String.format("%02d", (int) currentTime - 10));
            animationView_backward.setVisibility(View.VISIBLE);
            rlVideoPlayerNativePlayerControls.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationView_backward.setVisibility(View.GONE);
                    rlVideoPlayerNativePlayerControls.setVisibility(View.GONE);
                }
            }, 1200);
        } else if (keyCode == KeyEvent.KEYCODE_MEDIA_FAST_FORWARD) {
            tvVideoPlayerStartTime.setText(String.format("%02d", (int) currentTime + 10));
            mYoutubeView.moveForward(10);
            animationView_forward.setVisibility(View.VISIBLE);
            rlVideoPlayerNativePlayerControls.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationView_forward.setVisibility(View.GONE);
                    rlVideoPlayerNativePlayerControls.setVisibility(View.GONE);
                }
            }, 1200);
        } else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
            tvVideoPlayerStartTime.setText(String.format("%02d", (int) currentTime + 10));
            mYoutubeView.moveForward(10);
            animationView_forward.setVisibility(View.VISIBLE);
            rlVideoPlayerNativePlayerControls.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    animationView_forward.setVisibility(View.GONE);
                    rlVideoPlayerNativePlayerControls.setVisibility(View.GONE);
                }
            }, 1200);
        } else if (keyCode == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    if (rlVideoPlayerNativePlayerControls.getVisibility() == View.VISIBLE) {
                        rlVideoPlayerNativePlayerControls.setVisibility(View.GONE);
                        img_play_pause.setVisibility(View.GONE);
                    } else {
                        img_play_pause.setVisibility(View.VISIBLE);
                        rlVideoPlayerNativePlayerControls.setVisibility(View.VISIBLE);
                    }
                }
            });
        } else if (keyCode == KeyEvent.KEYCODE_BUTTON_A) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    if (rlVideoPlayerNativePlayerControls.getVisibility() == View.VISIBLE) {
                        rlVideoPlayerNativePlayerControls.setVisibility(View.GONE);
                        img_play_pause.setVisibility(View.GONE);
                    } else {
                        img_play_pause.setVisibility(View.VISIBLE);
                        rlVideoPlayerNativePlayerControls.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        return super.onKeyDown(keyCode, event);
    }

}