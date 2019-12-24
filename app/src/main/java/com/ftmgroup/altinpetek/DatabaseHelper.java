package com.ftmgroup.altinpetek;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ftmgroup.altinpetek.QuestionContract.QuestionTable.*;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.ftmgroup.altinpetek.QuestionContract.QuestionTable.*;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AltinPetek3.db";
    private static int DATABASE_VERSION = 3;

    private  SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                TABLE_NAME + " ( " +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUESTION + " TEXT, " +
                COLUMN_ANSWER1 + " TEXT, " +
                COLUMN_ANSWER2 + " TEXT, " +
                COLUMN_ANSWER3 + " TEXT, " +
                COLUMN_ANSWER4 + " TEXT, " +
                COLUMN_CORRECTANSWER + " INTEGER, " +
                COLUMN_DIFF + " INTEGER, " +
                COLUMN_SUBJECT + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        System.out.println(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE questions");
        onCreate(db);
    }
    private void fillQuestionTable(){
        Question q1 = new Question("Fatih Sultan Mehmet’in babası kimdir?","I. Mehmet","II. Murat","Yıldırım Beyazıt","II.Osman",2,0,"Tarih");
        addQuestion(q1);
        Question q2 = new Question("Hangi yabancı futbolcu Fenerbahçe forması giymiştir?","Prekazi","Schumacher","Simoviç","Taffarel",2,0,"Spor");
        addQuestion(q2);
        Question q3 = new Question("“Sinekli Bakkal” Romanının Yazarı Aşağıdakilerden Hangisidir?","Reşat Nuri Güntekin","Halide Edip Adıvar","Ziya Gökalp","Ömer Seyfettin",2,0,"Roman");
        addQuestion(q3);
        Question q4 = new Question("Aşağıda Verilen İlk Çağ Uygarlıklarından Hangisi Yazıyı İcat Etmiştir?","Hititler","Elamlar","Sümerler","Urartular",3,0,"Para");
        addQuestion(q4);
        Question q5 = new Question(" Tsunami Felaketinde En Fazla Zarar Gören Güney Asya Ülkesi Aşağıdakilerden Hangisidir?","Endonezya","Srilanka","Tayland","Hindistan",4,0,"Felaket");
        addQuestion(q5);
        Question q6 = new Question("Mustafa Kemal Atatürk’ün Nüfusa Kayıtlı Olduğu İl Hangisidir?","Bursa","Ankara","İstanbul","Gaziantep",4,0,"İl");
        addQuestion(q6);
        Question q7 = new Question("2003 Yılında Euro Vizyon Şarkı Yarışmasında Ülkemizi Temsil Eden ve Yarışmada Birinci Gelen Sanatçımız Kimdir?","Grup Athena","Sertap Erener","Şebnem Paker","Ajda Pekkan",2,0,"Müzik");
        addQuestion(q7);
        Question q8 = new Question("Aşağıdakilerden Hangisi Dünya Sağlık Örgütünün Kısaltılmış İsmidir?","Uhw","Unıcef","Who","Nato",3,1,"Sağlık");
        addQuestion(q8);
        Question q9 = new Question("Romen Rakamında Hangi Sayı Yoktur?","0","50","100","1000",1,0,"Rakam");
        addQuestion(q9);
        Question q10 = new Question("Bir Gün Kaç Saniyedir?","86000","88600","86400","84800",3,1,"Zaman");
        addQuestion(q10);
        Question q11 = new Question("Üç Büyük Dince Kutsal Sayılan Şehir Hangisidir?","Mekke","Kudüs","Roma","İstanbul",2,0,"Kutsal");
        addQuestion(q11);
        Question q12 = new Question("Hangi İlimizde Demiryolu Yoktur?","Batman","Kütahya","Aydın","Muğla",4,0,"Tren");
        addQuestion(q12);
        Question q13 = new Question("Hangi Ülkenin İki Tane Başkenti Vardır?","Güney Afrika","Senegal","El Salvador","Venezuela",1,1,"Başkent");
        addQuestion(q13);
        Question q14 = new Question("Bir Sebepten Dolayı Tek Kulağına Küpe Takan Osmanlı Padişahı Kimdir?","Kanuni Sultan Süleyman","Yavuz Sultan Selim","Orhan Bey","Fatih Sultan Selim",2,0,"Küpe");
        addQuestion(q14);
        Question q15 = new Question("Aşağıdaki Ülkelerden Hangisinin Nüfusu Daha Fazladır","İspanya ","Fransa ","İngiltere ","Almanya ",4,1,"Nüfus");
        addQuestion(q15);
        Question q16 = new Question("Aspirinin Hammaddesi Nedir?","Söğüt","Köknar","Kavak","Meşe",1,0,"İlaç");
        addQuestion(q16);
        Question q17 = new Question("Futbol Maçlarında Oynanan Topun Fifa Kurallarına Göre Ağırlığı Ne Kadar Olmalıdır?","442gr","452gr","462gr","482gr",2,1,"Futbol");
        addQuestion(q17);
        Question q18 = new Question("Mehmet Akif Ersoy İstiklal Marşını nerede yazmıştır?","Ankara - Ayasofya","Ankara - Keçiören Camisi","Ankara - Ayaş Dergahi","Ankara - Taceddin Dergahı",4,0,"Marş");
        addQuestion(q18);
        Question q19 = new Question("Atatürk'ün yurt gezilerinde (1935-1938) yılları arasında kullandığı trenin adı nedir?","Beyaz Tren","Kara Duman","Demir Türk","Anadolu",1,1,"Gezi");
        addQuestion(q19);
        Question q20 = new Question("Türkiye'nin ilk Safari Parkı hangi ilimizde açılmıştır?","Mersin","İzmir","Gaziantep","Konya",3,0,"Safari");
        addQuestion(q20);
        Question q21 = new Question("Birleşmiş Milletler Dünya Turizm Örgütü'nün kısa adı hangisidir?","UNOWT","UWT","WTO","UNWTO",4,0,"Turizm");
        addQuestion(q21);
        Question q22 = new Question("Büyük bir Destan olan \"BÜLBÜL\" hangi ilimizin işgali üzerine yazılmıştır?","Adana","İzmir","Bursa","Bolu",3,0,"Bülbül");
        addQuestion(q22);
        Question q23 = new Question("Başlıyoruz. Ankara ne zaman başkent olmuştur?","1923","1933","1919","1922",0,0,"Ankara");
        addQuestion(q23);
        Question q24 = new Question("Hangisi sürüngenler sınıfından bir hayvandır?","Kurbağa","Kertenkele","Salyangoz","Karınca",2,0,"Sürüngen");
        addQuestion(q24);
        Question q25 = new Question("Hangi şehir İskandinavya'dadır?","Kopenhag","Reykjavik","Stockholm","Amsterdam",1,0,"İskandinavya");
        addQuestion(q25);
        Question q26 = new Question("Hangisi bir asal sayıdır?","33","51","44","23",4,0,"Asal");
        addQuestion(q26);
        Question q27 = new Question("Hangi gezegen Güneş'e daha uzak mesafededir?","Dünya","Mars","Venüs","Jupiter",4,0,"Uzay");
        addQuestion(q27);
        Question q28 = new Question("Hangi bitki buğdaygiller ailesinden değildir?","Pirinç","Nohut","Mısır","Bulgur",2,0,"Safari");
        addQuestion(q28);
        Question q29 = new Question("Magna Carta hangi ülkenin kralıyla yapılmış bir sözleşmedir?","İngiltere","İspanya","Fransa","Yunanistan",1,0,"Sözleşme");
        addQuestion(q29);



    }
    private void addQuestion(Question question){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_QUESTION, question.getQuestion());
        cv.put(COLUMN_ANSWER1, question.getAnswer1());
        cv.put(COLUMN_ANSWER2, question.getAnswer2());
        cv.put(COLUMN_ANSWER3, question.getAnswer3());
        cv.put(COLUMN_ANSWER4, question.getAnswer4());
        cv.put(COLUMN_CORRECTANSWER, question.getCorrectAnswer());
        cv.put(COLUMN_DIFF, question.getDifficulty());
        cv.put(COLUMN_SUBJECT, question.getSubject());

        db.insert(TABLE_NAME, null,cv);
    }
    public List<Question> getAllQuestions(String subject){
        List<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_SUBJECT + "=?",new String[] { String.valueOf(subject) } );

        if(c.moveToFirst()){
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(COLUMN_QUESTION)));
                question.setAnswer1(c.getString(c.getColumnIndex(COLUMN_ANSWER1)));
                question.setAnswer2(c.getString(c.getColumnIndex(COLUMN_ANSWER2)));
                question.setAnswer3(c.getString(c.getColumnIndex(COLUMN_ANSWER3)));
                question.setAnswer4(c.getString(c.getColumnIndex(COLUMN_ANSWER4)));
                question.setCorrectAnswer(c.getInt(c.getColumnIndex(COLUMN_CORRECTANSWER)));
                question.setDifficulty(c.getInt(c.getColumnIndex(COLUMN_DIFF)));
                question.setSubject(c.getString(c.getColumnIndex(COLUMN_SUBJECT)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }


    public void setArrayPrefs(String arrayName, ArrayList<String> array, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("ArraySharedPref", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(arrayName +"_size", array.size());
        for(int i=0;i<array.size();i++)
            editor.putString(arrayName + "_" + i, array.get(i));
        editor.apply();
    }

    public ArrayList<String> getArrayPrefs(String arrayName, Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("ArraySharedPref", 0);
        int size = prefs.getInt(arrayName + "_size", 0);
        ArrayList<String> array = new ArrayList<>(size);
        for(int i=0;i<size;i++)
            array.add(prefs.getString(arrayName + "_" + i, null));
        return array;
    }
}
