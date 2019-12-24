package com.ftmgroup.altinpetek;

import android.provider.BaseColumns;

public final class QuestionContract {

    private QuestionContract(){}
    // DATABASE STRINGS
    public static class QuestionTable implements BaseColumns {
        public static final String TABLE_NAME = "questions";
        public static final String COLUMN_QUESTION = "question";
        public static final String COLUMN_ANSWER1 = "answer1";
        public static final String COLUMN_ANSWER2 = "answer2";
        public static final String COLUMN_ANSWER3 = "answer3";
        public static final String COLUMN_ANSWER4 = "answer4";
        public static final String COLUMN_CORRECTANSWER = "correctanswer";
        public static final String COLUMN_DIFF = "difficulty";
        public static final String COLUMN_SUBJECT = "subject";
    }
}
