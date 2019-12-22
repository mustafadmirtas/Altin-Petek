package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView logoImage;
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoImage= findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progress_bar);
        textView = findViewById(R.id.textView);

        progressBar.setMax(100);
        progressBar.setScaleY(7f);
        progressAnimation();
        logoAnimation();

    }
    //Progress Bar ANIMATION CREATE AND PLAY
    public void progressAnimation(){
        ProgressBarAnimation anim = new ProgressBarAnimation(this,progressBar,textView,0f,100f);
        anim.setDuration(8000);
        progressBar.setAnimation(anim);
    }
    //LOGO ANIMATION CREATE AND PLAY
    public void logoAnimation(){
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(logoImage, "y", 0f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(logoImage, "x", 0f);
        animatorX.setDuration(1000);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX,animatorY);
        animatorSet.start();
    }
}
