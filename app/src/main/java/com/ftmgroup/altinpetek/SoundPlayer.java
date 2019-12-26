package com.ftmgroup.altinpetek;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {
    private static SoundPool soundPool;
    private static int clickSound;
    private static int correctSound;
    private static int wrongSound;
    private static int introSound;
    private static int applauseSound;
    private static int sound = 1;



    public SoundPlayer(Context context){
            soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC,0);

            clickSound= soundPool.load(context,R.raw.click, 1);
            correctSound = soundPool.load(context,R.raw.correct,1);
            wrongSound = soundPool.load(context,R.raw.wrong,1);
            introSound = soundPool.load(context,R.raw.intro,1);
            applauseSound = soundPool.load(context,R.raw.applause,1);




    }
    public void playClickSound(){
        soundPool.play(clickSound,sound,sound,1,0,1);
    }
    public void playCorrectSound(){
        soundPool.play(correctSound,sound,sound,1,0,1);
    }
    public void playWrongSound(){
        soundPool.play(wrongSound,sound,sound,1,0,1);
    }
    public void playIntroSound(){
        soundPool.play(introSound,sound,sound,1,0,1);
    }
    public void playApplauseSound(){
        soundPool.play(applauseSound,sound,sound,1,0,1);
    }

    public void muteSounds(boolean bool){
        if(bool==false){
            setSound(1);
        }else {
            setSound(0);
        }

    }
    public static int getSound() {
        return sound;
    }

    public static void setSound(int sound) {
        SoundPlayer.sound = sound;
    }
}
