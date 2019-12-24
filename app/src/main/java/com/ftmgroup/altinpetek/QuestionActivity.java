package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {
    private List<Question> questionList;
    SharedPreferences mPrefs = getPreferences(MODE_PRIVATE);
    ArrayList<String> history = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        // MAKE FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        TextView text_question = findViewById(R.id.txt_question);
        final Button btn_a1 = findViewById(R.id.btn_answer1);
        Button btn_a2 = findViewById(R.id.btn_answer2);
        Button btn_a3 = findViewById(R.id.btn_answer3);
        Button btn_a4 = findViewById(R.id.btn_answer4);
        int correctAnswer;
        DatabaseHelper db = new DatabaseHelper(this);
        questionList = db.getAllQuestions("Tren");
        text_question.setText(questionList.get(0).getQuestion());
        btn_a1.setText(questionList.get(0).getAnswer1());
        btn_a2.setText(questionList.get(0).getAnswer2());
        btn_a3.setText(questionList.get(0).getAnswer3());
        btn_a4.setText(questionList.get(0).getAnswer4());
        correctAnswer = questionList.get(0).getCorrectAnswer();

        history = db.getArrayPrefs("History",null);

        btn_a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(correctAnswer == 1){
                    btn_a1.setBackground(getResources().getDrawable(R.drawable.questiontype2));
                    //history.add();
                } else {
                    btn_a1.setBackground(getResources().getDrawable(R.drawable.questiontype3));
                }
            }
        });



    }
}
