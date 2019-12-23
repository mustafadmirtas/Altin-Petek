package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.lang.reflect.Array;

public class MainGame extends AppCompatActivity implements View.OnClickListener {
    int[][] Road= {/*0*/{1},/*1*/{2,3,4},/*2*/{5,6,3},/*3*/{6,7,8},/*4*/{3,8,9},/*5*/{10,6},/*6*/{10,11,7},
            /*7*/{11,12,13},/*8*/{7,13,14},/*9*/{8,14},/*10*/{15,11},/*11*/{15,16,12},/*12*/{16,17,18},/*13*/{12,18,19},/*14*/{13,19}
            /*15*/,{20,16},/*16*/{20,21,17},/*17*/{21,22,23},/*18*/{17,23,24},/*19*/{18,24},/*20*/{25,21},/*21*/{25,26,22},/*22*/{26,27,28},/*23*/{22,28,29},
            /*24*/{23,29},/*25*/{26},/*26*/{27},/*27*/{27},/*28*/{27},/*29*/{28}};
    Button buttons[] = new Button[29];
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        // MAKE FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // this makes fullscreen game.
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        createButtons();
        //syncHistory();


    }
    private void createButtons(){
        buttons[0] = findViewById(R.id.button);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button6);
        buttons[4] = findViewById(R.id.button9);
        buttons[5] = findViewById(R.id.button5);
        buttons[6] = findViewById(R.id.button8);
        buttons[7] = findViewById(R.id.button4);
        buttons[8] = findViewById(R.id.button7);
        buttons[9] = findViewById(R.id.button14);
        buttons[10] = findViewById(R.id.button13);
        buttons[11] = findViewById(R.id.button11);
        buttons[12] = findViewById(R.id.button10);
        buttons[13] = findViewById(R.id.button15);
        buttons[14] = findViewById(R.id.button12);
        buttons[15] = findViewById(R.id.button19);
        buttons[16] = findViewById(R.id.button16);
        buttons[17] = findViewById(R.id.button18);
        buttons[18] = findViewById(R.id.button24);
        buttons[19] = findViewById(R.id.button23);
        buttons[20] = findViewById(R.id.button17);
        buttons[21] = findViewById(R.id.button21);
        buttons[22] = findViewById(R.id.button20);
        buttons[23] = findViewById(R.id.button25);
        buttons[24] = findViewById(R.id.button29);
        buttons[25] = findViewById(R.id.button22);
        buttons[26] = findViewById(R.id.button28);
        buttons[27] = findViewById(R.id.button26);
        buttons[28] = findViewById(R.id.button27);
        for (int i = 0; i<29; i++){
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        // WHEN CLICK ONE BUTTON WE ARE SEND BUTTON TEXT ITS FOR SUBJECT OF QUESTION
        // AND WHICH LEVEL OF BUTTON IN TAGS FOR EX 2nd button TAG 2 LEVEL 2 QUESTION COMES ABOUT CLICKED SUBJECT
        Intent i = new Intent(MainGame.this,QuestionActivity.class);
        Button b = (Button)view;
        if(view.getId() != R.id.button && b.getText() != null && b.getTag() != null){
            i.putExtra("QuestionType", (String) b.getText());
            i.putExtra("Level", (Integer) b.getTag());
            startActivity(i);
        } else {
            i.putExtra("QuestionType", "Random");
            i.putExtra("Level", 0);
            startActivity(i);
        }
    }
    public void syncHistory(){

    }
}
