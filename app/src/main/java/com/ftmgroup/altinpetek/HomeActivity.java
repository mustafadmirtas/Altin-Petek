package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private SoundPlayer soundPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // MAKE FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        soundPlayer = new SoundPlayer(this);

        Button buttonStart,buttonOptions,buttonCredits,buttonExit;
        buttonStart = findViewById(R.id.start_button);
        buttonOptions = findViewById(R.id.options_button);
        buttonCredits = findViewById(R.id.credits_button);
        buttonExit = findViewById(R.id.exit_button);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButton(0);
                soundPlayer.playClickSound();
            }
        });
        buttonOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButton(1);
                soundPlayer.playClickSound();
            }
        });
        buttonCredits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButton(2);
                soundPlayer.playClickSound();
            }
        });
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButton(3);
                soundPlayer.playClickSound();
            }
        });
    }
    public void onClickButton(int optNumber){
        SharedPreferences sharedPreferences = this.getSharedPreferences("SharedPref",Context.MODE_PRIVATE);
        switch(optNumber){
            case 0: // MainGame or HelperActivity
                // If the first play we are going HELPER activty to tell how to play game
                Boolean first = sharedPreferences.getBoolean("FirstPlay",true);
                if (first){
                    Intent i = new Intent(HomeActivity.this,HelperActivity.class);
                    startActivity(i);
                } else {
                    if (sharedPreferences.getInt("isQuestionState",0) == 0){
                        Intent i = new Intent(HomeActivity.this,MainGame.class);
                        startActivity(i);
                    } else {
                        Intent i = new Intent(HomeActivity.this,QuestionActivity.class);
                        i.putExtra("QuestionType", sharedPreferences.getString("SubjectStart",null));
                        i.putExtra("ButtonTag",sharedPreferences.getString("ButonTag",null));
                        startActivity(i);
                    }

                }
                break;
            case 1: // OptionsActivtiy
                Intent i = new Intent(HomeActivity.this,OptionsActivity.class);
                startActivity(i);
                break;
            case 2: // CreditsActivity
                Intent b = new Intent(HomeActivity.this,CreditsActivity.class);
                startActivity(b);
                break;
            case 3: // ExitButtonClick
                finish();
                break;
            default:
                break;
        }
    }
}
