package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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
    ArrayList<String> SubjectList = new ArrayList<String>();
    DatabaseHelper db = new DatabaseHelper(this);
    Button btn_a1,btn_a2,btn_a3,btn_a4,btn_silver,btn_bron1,btn_bron2,btn_bron3;
    String btntag;
 ;  int silverCount,bronzCount;
    boolean isSilverClicked = false, isBronzeClicked=false;
    SharedPreferences sharedPreferences;
    SoundPlayer soundPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        // MAKE FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        soundPlayer = new SoundPlayer(this);

        Intent i = getIntent();
        final String subject = i.getStringExtra("QuestionType");
        btntag = i.getStringExtra("ButtonTag");
        sharedPreferences = this.getSharedPreferences("SharedPref", Context.MODE_PRIVATE);

        Log.d("A",btntag);

        TextView text_question = findViewById(R.id.txt_question);
        btn_a1 = findViewById(R.id.btn_answer1);
        btn_a2 = findViewById(R.id.btn_answer2);
        btn_a3 = findViewById(R.id.btn_answer3);
        btn_a4 = findViewById(R.id.btn_answer4);

        final int correctAnswer;
        questionList = db.getAllQuestions(subject);
        SubjectList = db.getArrayPrefs("Subjects",this);

        text_question.setText(questionList.get(0).getQuestion());
        btn_a1.setText(questionList.get(0).getAnswer1());
        btn_a2.setText(questionList.get(0).getAnswer2());
        btn_a3.setText(questionList.get(0).getAnswer3());
        btn_a4.setText(questionList.get(0).getAnswer4());
        correctAnswer = questionList.get(0).getCorrectAnswer();

        btn_silver =findViewById(R.id.btn_silver);
        btn_bron1 = findViewById(R.id.btn_bron1);
        btn_bron2 = findViewById(R.id.btn_bron2);
        btn_bron3 = findViewById(R.id.btn_bron3);

        history = db.getArrayPrefs("History",this);
        checkJokers();

        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("isQuestionState",1);
        editor.putString("SubjectStart",subject);
        editor.putString("ButonTag",btntag);
        editor.commit();


        btn_a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrect(btn_a1,1,correctAnswer,btntag,subject);
                soundPlayer.playClickSound();
            }
        });
        btn_a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCorrect(btn_a2,2,correctAnswer,btntag,subject);
                soundPlayer.playClickSound();
            }
        });
        btn_a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCorrect(btn_a3,3,correctAnswer,btntag,subject);
                soundPlayer.playClickSound();
            }
        });
        btn_a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCorrect(btn_a4,4,correctAnswer,btntag,subject);
                soundPlayer.playClickSound();
            }
        });

        btn_silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useSilver();
                soundPlayer.playClickSound();
            }
        });
        btn_bron1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useBronze();
                soundPlayer.playClickSound();
            }
        });
        btn_bron2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useBronze();
                soundPlayer.playClickSound();
            }
        });
        btn_bron3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useBronze();
                soundPlayer.playClickSound();
            }
        });

    }
    private void sendArray(){
            db.setArrayPrefs("History",history,this);
            db.setArrayPrefs("Subjects",SubjectList,this);
    }
    private void finishGame(){

    }
    private void checkCorrect(Button button,int btn,int correctanswer,String btntag, String subject){
        btn_a1.setEnabled(false);
        btn_a2.setEnabled(false);
        btn_a3.setEnabled(false);
        btn_a4.setEnabled(false);
        if(isSilverClicked){
            showCorrectAnswer(correctanswer);
            soundPlayer.playCorrectSound();
            if(btn != correctanswer){
                button.setBackground(getResources().getDrawable(R.drawable.questiontype3));
            }
            history.add(btntag);
            SubjectList.remove(subject);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    finishCheck();
                }
            }, 1000);
            isSilverClicked = false;
        }
        else if(isBronzeClicked){
            if(btn == correctanswer){
                soundPlayer.playCorrectSound();
                button.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                history.add(btntag);
                SubjectList.remove(subject);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finishCheck();
                    }
                }, 1000);   //1 seconds
            } else {
                button.setBackground(getResources().getDrawable(R.drawable.questiontype3));
                btn_a1.setEnabled(true);
                btn_a2.setEnabled(true);
                btn_a3.setEnabled(true);
                btn_a4.setEnabled(true);
                button.setEnabled(false);
                isBronzeClicked=false;
            }
        }
        else{
            if(btn == correctanswer){
                soundPlayer.playCorrectSound();
                button.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                history.add(btntag);
                SubjectList.remove(subject);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finishCheck();
                    }
                }, 1000);   //1 seconds

            } else {
                soundPlayer.playWrongSound();
                history.clear();
                button.setBackground(getResources().getDrawable(R.drawable.questiontype3));
                showCorrectAnswer(correctanswer);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finishCheck();
                    }
                }, 1000);//1 seconds
            }
        }

    }
    private void finishCheck(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("isQuestionState", 0);
        editor.remove("SubjectStart");
        editor.remove("ButonTag");
        editor.commit();
        int a = Integer.parseInt(btntag);
        if(a!=27) {
            sendArray();
            Intent i = new Intent(QuestionActivity.this, MainGame.class);
            startActivity(i);
            finish();
        } else {
            Intent i = new Intent(QuestionActivity.this, FinishActivity.class);
            i.putExtra("Money",history.size());
            resetJokers();
            history.clear();
            sendArray();
            startActivity(i);
            finish();
        }
    }
    private void checkJokers() {
        silverCount = sharedPreferences.getInt("SilverCount", 1);
        bronzCount = sharedPreferences.getInt("BronzeCount", 3);
        if (silverCount == 0) {
            this.btn_silver.setVisibility(View.INVISIBLE);
        }
        switch (bronzCount) {
            case 0:
                btn_bron1.setVisibility(View.INVISIBLE);
                btn_bron2.setVisibility(View.INVISIBLE);
                btn_bron3.setVisibility(View.INVISIBLE);
                break;
            case 1:
                btn_bron1.setVisibility(View.INVISIBLE);
                btn_bron2.setVisibility(View.INVISIBLE);
                btn_bron3.setEnabled(true);
                break;
            case 2:
                btn_bron1.setVisibility(View.INVISIBLE);
                btn_bron2.setEnabled(true);
                btn_bron3.setEnabled(true);
                break;
            case 3:
                btn_bron1.setEnabled(true);
                btn_bron2.setEnabled(true);
                btn_bron3.setEnabled(true);
                break;
        }
    }
    private void useSilver(){
        silverCount -= 1;
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("SilverCount",silverCount);
        editor.commit();
        isSilverClicked = true;
        btn_bron1.setEnabled(false);
        btn_bron2.setEnabled(false);
        btn_bron3.setEnabled(false);
        btn_silver.setEnabled(false);
        checkJokers();
    }
    private void useBronze(){
        bronzCount -= 1;
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("BronzeCount",bronzCount);
        editor.commit();
        isBronzeClicked = true;
        btn_bron1.setEnabled(false);
        btn_bron2.setEnabled(false);
        btn_bron3.setEnabled(false);
        btn_silver.setEnabled(false);
        checkJokers();
    }
    private void resetJokers(){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt("BronzeCount",3);
        editor.putInt("SilverCount",1);
        editor.commit();
    }
    private void showCorrectAnswer(int correctAnswer){
        switch (correctAnswer){
            case 1:
                btn_a1.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                break;
            case 2:
                btn_a2.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                break;
            case 3:
                btn_a3.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                break;
            case 4:
                btn_a4.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                break;
        }
    }
    private void correctAnimation(boolean bool){

    }
}
