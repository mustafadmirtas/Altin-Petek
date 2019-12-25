package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class QuestionActivity extends Activity {
    private List<Question> questionList;
    ArrayList<String> history = new ArrayList<String>();
    DatabaseHelper db = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        // MAKE FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        Intent i = getIntent();
        String subject = i.getStringExtra("QuestionType");
        final String btntag = i.getStringExtra("ButtonTag");

        TextView text_question = findViewById(R.id.txt_question);
        final Button btn_a1 = findViewById(R.id.btn_answer1);
        final Button btn_a2 = findViewById(R.id.btn_answer2);
        final Button btn_a3 = findViewById(R.id.btn_answer3);
        final Button btn_a4 = findViewById(R.id.btn_answer4);
        final int correctAnswer;
        questionList = db.getAllQuestions(subject);
        text_question.setText(questionList.get(0).getQuestion());
        btn_a1.setText(questionList.get(0).getAnswer1());
        btn_a2.setText(questionList.get(0).getAnswer2());
        btn_a3.setText(questionList.get(0).getAnswer3());
        btn_a4.setText(questionList.get(0).getAnswer4());
        correctAnswer = questionList.get(0).getCorrectAnswer();

        history = db.getArrayPrefs("History",this);

        btn_a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_a1.setEnabled(false);
                btn_a2.setEnabled(false);
                btn_a3.setEnabled(false);
                btn_a4.setEnabled(false);
                if(correctAnswer == 1){
                    btn_a1.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                    history.add(btntag);
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                } else {
                    btn_a1.setBackground(getResources().getDrawable(R.drawable.questiontype3));
                    history.clear();
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                }
            }
        });
        btn_a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_a1.setEnabled(false);
                btn_a2.setEnabled(false);
                btn_a3.setEnabled(false);
                btn_a4.setEnabled(false);
                if(correctAnswer == 2){
                    btn_a2.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                    history.add(btntag);
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                } else {
                    btn_a2.setBackground(getResources().getDrawable(R.drawable.questiontype3));
                    history.clear();
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                }
            }
        });
        btn_a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_a1.setEnabled(false);
                btn_a2.setEnabled(false);
                btn_a3.setEnabled(false);
                btn_a4.setEnabled(false);
                if(correctAnswer == 3){
                    btn_a3.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                    history.add(btntag);
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                } else {
                    btn_a3.setBackground(getResources().getDrawable(R.drawable.questiontype3));
                    history.clear();
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                }
            }
        });
        btn_a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_a1.setEnabled(false);
                btn_a2.setEnabled(false);
                btn_a3.setEnabled(false);
                btn_a4.setEnabled(false);
                if(correctAnswer == 4){
                    btn_a4.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                    Log.d("ASd",btntag);
                    history.add(btntag);
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                } else {
                    btn_a4.setBackground(getResources().getDrawable(R.drawable.questiontype3));
                    history.clear();
                    sendArray();
                    Intent i = new Intent(QuestionActivity.this, MainGame.class);
                    startActivity(i);
                }
            }
        });



    }
    private void sendArray(){
            db.setArrayPrefs("History",history,this);
    }
}
