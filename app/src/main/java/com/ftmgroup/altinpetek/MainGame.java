package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainGame extends AppCompatActivity implements View.OnClickListener {
    int[][] Road= {/*0*/{1},/*1*/{2,3,4},/*2*/{5,6,3},/*3*/{6,7,8},/*4*/{3,8,9},/*5*/{10,6},/*6*/{10,11,7},
            /*7*/{11,12,13},/*8*/{7,13,14},/*9*/{8,14},/*10*/{15,11},/*11*/{15,16,12},/*12*/{16,17,18},/*13*/{12,18,19},/*14*/{13,19}
            /*15*/,{20,16},/*16*/{20,21,17},/*17*/{21,22,23},/*18*/{17,23,24},/*19*/{18,24},/*20*/{25,21},/*21*/{25,26,22},/*22*/{26,27,28},/*23*/{22,28,29},
            /*24*/{23,29},/*25*/{26},/*26*/{27},/*27*/{27},/*28*/{27},/*29*/{28}};
    Button buttons[] = new Button[30];
    DatabaseHelper db = new DatabaseHelper(this);
    SoundPlayer soundPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        // MAKE FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); // this makes fullscreen game.
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        createButtons();
        syncHistory();
        soundPlayer = new SoundPlayer(this);


    }
    private void createButtons(){

        buttons[0] = findViewById(R.id.button);
        buttons[1] = findViewById(R.id.button);
        buttons[2] = findViewById(R.id.button2);
        buttons[3] = findViewById(R.id.button3);
        buttons[4] = findViewById(R.id.button4);
        buttons[5] = findViewById(R.id.button5);
        buttons[6] = findViewById(R.id.button6);
        buttons[7] = findViewById(R.id.button7);
        buttons[8] = findViewById(R.id.button8);
        buttons[9] = findViewById(R.id.button9);
        buttons[10] = findViewById(R.id.button10);
        buttons[11] = findViewById(R.id.button11);
        buttons[12] = findViewById(R.id.button12);
        buttons[13] = findViewById(R.id.button13);
        buttons[14] = findViewById(R.id.button14);
        buttons[15] = findViewById(R.id.button15);
        buttons[16] = findViewById(R.id.button16);
        buttons[17] = findViewById(R.id.button17);
        buttons[18] = findViewById(R.id.button18);
        buttons[19] = findViewById(R.id.button19);
        buttons[20] = findViewById(R.id.button20);
        buttons[21] = findViewById(R.id.button21);
        buttons[22] = findViewById(R.id.button22);
        buttons[23] = findViewById(R.id.button23);
        buttons[24] = findViewById(R.id.button24);
        buttons[25] = findViewById(R.id.button25);
        buttons[26] = findViewById(R.id.button26);
        buttons[27] = findViewById(R.id.button27);
        buttons[28] = findViewById(R.id.button28);
        buttons[29] = findViewById(R.id.button29);
        for (int i = 0; i<30; i++){
            buttons[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        soundPlayer.playClickSound();
        // WHEN CLICK ONE BUTTON WE ARE SEND BUTTON TEXT ITS FOR SUBJECT OF QUESTION
        // AND WHICH LEVEL OF BUTTON IN TAGS FOR EX 2nd button TAG 2 LEVEL 2 QUESTION COMES ABOUT CLICKED SUBJECT
        Intent i = new Intent(MainGame.this,QuestionActivity.class);
        Button b = (Button)view;
        System.out.println(b.getText());
        if(b.getText() !="" && b.getTag() != null){
            i.putExtra("QuestionType", (String) b.getText());
            i.putExtra("ButtonTag", (String) b.getTag());
            startActivity(i);
            finish();

        } else {
            ArrayList<String> SubjectList = new ArrayList<String>();
            SubjectList = db.getArrayPrefs("Subjects",this);
            i.putExtra("QuestionType",SubjectList.get(new Random().nextInt(SubjectList.size())));
            i.putExtra("ButtonTag", "1");
            startActivity(i);
            finish();
        }
    }
    public void syncHistory(){
            DatabaseHelper db = new DatabaseHelper(this);
            ArrayList<String> history = new ArrayList<String>();
            history = db.getArrayPrefs("History",this);
            int lastIndex=1;

            for (int i =0; i<history.size(); i++){
                  if(history.size() >= 1){
                  buttons[Integer.parseInt(history.get(i))].setBackground(getResources().getDrawable(R.drawable.greenpetek));
                  buttons[Integer.parseInt(history.get(i))].setText(String.valueOf(1000 * i * i + 1000));
                  buttons[Integer.parseInt(history.get(i))].setEnabled(false);
                  lastIndex = Integer.parseInt(history.get(i));
                  }
            }


            if(history.size() >= 1){
                randomSubjects(lastIndex);
            }
            else {
                historyOfSubjectReset();
            }

    }
    private void randomSubjects(int lastIndex){
            ArrayList<String> SubjectList = new ArrayList<String>();
            SubjectList = db.getArrayPrefs("Subjects",this);
            int a[]= Road[lastIndex];
            ArrayList<Integer> randomlist = new ArrayList<Integer>();

            for(int i = 0; i<a.length; i++){
                int random = new Random().nextInt(SubjectList.size());
                if(randomlist.contains(random)){
                    random = new Random().nextInt(SubjectList.size());
                }
                buttons[a[i]].setBackground(getResources().getDrawable(R.drawable.bluepetek));
                buttons[a[i]].setText(SubjectList.get(random));
                buttons[a[i]].setEnabled(true);
                randomlist.add(random);
            }
            randomlist.clear();
    }
    public void historyOfSubjectReset(){

        ArrayList<String> SubjectList = new ArrayList<String>();
        SubjectList.add("Tarih");
        SubjectList.add("Spor");
        SubjectList.add("Roman");
        SubjectList.add("Para");
        SubjectList.add("Felaket");
        SubjectList.add("İl");
        SubjectList.add("Müzik");
        SubjectList.add("Sağlık");
        SubjectList.add("Rakam");
        SubjectList.add("Zaman");
        SubjectList.add("Kutsal");
        SubjectList.add("Tren");
        SubjectList.add("Başkent");
        SubjectList.add("Küpe");
        SubjectList.add("Nüfus");
        SubjectList.add("İlaç");
        SubjectList.add("Futbol");
        SubjectList.add("Marş");
        SubjectList.add("Gezi");
        SubjectList.add("Safari");
        SubjectList.add("Turizm");
        SubjectList.add("Bülbül");
        SubjectList.add("Ankara");
        SubjectList.add("Sürüngen");
        SubjectList.add("İskandinavya");
        SubjectList.add("Asal");
        SubjectList.add("Uzay");
        SubjectList.add("Safari");
        SubjectList.add("Sözleşme");
        db.setArrayPrefs("Subjects",SubjectList,this);
    }
}
