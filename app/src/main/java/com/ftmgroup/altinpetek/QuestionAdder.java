package com.ftmgroup.altinpetek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionAdder extends AppCompatActivity {
    DatabaseHelper db = new DatabaseHelper(this);
    EditText q,a1,a2,a3,a4,answer,diff,subj;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_adder);
        q = findViewById(R.id.question_text);
        a1 = findViewById(R.id.a1_text);
        a2 = findViewById(R.id.a2_text);
        a3 = findViewById(R.id.a3_text);
        a4 = findViewById(R.id.a4_text);
        answer = findViewById(R.id.answer_text);
        diff = findViewById(R.id.diff_text);
        subj = findViewById(R.id.subject_text);
        button = findViewById(R.id.save_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qtext = q.getText().toString();
                String a1text = a1.getText().toString();
                String a2text = a2.getText().toString();
                String a3text = a3.getText().toString();
                String a4text = a4.getText().toString();
                String answertext = answer.getText().toString();
                String difftext = diff.getText().toString();
                String subjtext = subj.getText().toString();




                if(qtext.equals("") || a1text.equals("") || a2text.equals("") || a3text.equals("")|| a4text.equals("") || answertext.equals("") || difftext.equals("")
                        || subjtext.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    boolean insert = db.insert(qtext,a1text,a2text,a3text,a4text,answertext,Integer.parseInt(difftext),subjtext);
                    if(insert==true){
                        Toast.makeText(getApplicationContext(),"SAVED", Toast.LENGTH_LONG).show();
                    } else{
                        Toast.makeText(getApplicationContext(),"ERROR", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
