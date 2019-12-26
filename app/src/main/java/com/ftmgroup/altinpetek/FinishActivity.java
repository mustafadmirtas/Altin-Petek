package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    SoundPlayer soundPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        soundPlayer = new SoundPlayer(this);
        soundPlayer.playApplauseSound();

        TextView textView = findViewById(R.id.textView_money);

        Intent i = getIntent();
        int money = i.getIntExtra("Money",1000);

        money = 1000 * money * money + 1000;

        textView.setText(String.valueOf(money));

        Button button = findViewById(R.id.button_pagain);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=  new Intent(FinishActivity.this,HomeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
