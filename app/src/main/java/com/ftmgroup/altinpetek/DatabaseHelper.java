package com.ftmgroup.altinpetek;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Text;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context){
        super(context,"QuestionDB.db",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table questions(qid int primary key , question text, a1 text, a2 text, a3 text,a4 text, answer, diff int, subject text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists questions");
    }
    public boolean insert(String question, String a1,String a2,String a3, String a4, String answer, int diff, String subject){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("question", question);
        contentValues.put("a1", a1);
        contentValues.put("a2", a2);
        contentValues.put("a3", a3);
        contentValues.put("a4", a4);
        contentValues.put("answer", answer);
        contentValues.put("diff", diff);
        contentValues.put("subject", subject);
        long ins = db.insert(question,null,contentValues);
        if(ins==-1)
            return false;
        else return true;

    }
}
