package com.example.relativepitchtrainer;

import static android.media.MediaPlayer.create;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.Random;


public class Sounds {


    private final MediaPlayer[] majors;
    private final MediaPlayer[] minors;
    private final MediaPlayer[] perfects;

    private MediaPlayer currentSound;


    public Sounds(Context context) {

       majors = new MediaPlayer[] {
               MediaPlayer.create(context, R.raw.major1),
               MediaPlayer.create(context, R.raw.major2),
               MediaPlayer.create(context, R.raw.major3),
               MediaPlayer.create(context, R.raw.major4),
               MediaPlayer.create(context, R.raw.major5),
               MediaPlayer.create(context, R.raw.major6),
               MediaPlayer.create(context, R.raw.major7),
               MediaPlayer.create(context, R.raw.major8),
               MediaPlayer.create(context, R.raw.major9),
               MediaPlayer.create(context, R.raw.major10),
               MediaPlayer.create(context, R.raw.major11),
               MediaPlayer.create(context, R.raw.major12)
        };


        minors = new MediaPlayer[] {
                MediaPlayer.create(context, R.raw.m1),
                MediaPlayer.create(context, R.raw.m2),
                MediaPlayer.create(context, R.raw.m3),
                MediaPlayer.create(context, R.raw.m4),
                MediaPlayer.create(context, R.raw.m5),
                MediaPlayer.create(context, R.raw.m6),
                MediaPlayer.create(context, R.raw.m7),
                MediaPlayer.create(context, R.raw.m8),
                MediaPlayer.create(context, R.raw.m9),
                MediaPlayer.create(context, R.raw.m10),
                MediaPlayer.create(context, R.raw.m11),
                MediaPlayer.create(context, R.raw.m12)
        };

        perfects = new MediaPlayer[] {
                MediaPlayer.create(context, R.raw.p1),
                MediaPlayer.create(context, R.raw.p2),
                MediaPlayer.create(context, R.raw.p3),
                MediaPlayer.create(context, R.raw.p4),
                MediaPlayer.create(context, R.raw.p5),
                MediaPlayer.create(context, R.raw.p6),
                MediaPlayer.create(context, R.raw.p7),
                MediaPlayer.create(context, R.raw.p8),
                MediaPlayer.create(context, R.raw.p9),
                MediaPlayer.create(context, R.raw.p10),
                MediaPlayer.create(context, R.raw.p11),
                MediaPlayer.create(context, R.raw.p12)
        };

    }

    public MediaPlayer getRandomMajor() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(majors.length);
        return majors[randomIndex];
    }


    public MediaPlayer getRandomMinors() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(minors.length);
        return minors[randomIndex];
    }

    public MediaPlayer getRandomPerfects() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(perfects.length);
        return perfects[randomIndex];
    }

    public MediaPlayer getRandomP8_m3() {
        Random rand = new Random();
        int randomArray = rand.nextInt(2);
        MediaPlayer[] players = randomArray == 0 ? minors : perfects;
        int randomIndex = rand.nextInt(players.length);
        currentSound = players[randomIndex];
        return currentSound;
    }

    public MediaPlayer getRandomM3_m3() {
        Random rand = new Random();
        int randomArray = rand.nextInt(2);
        MediaPlayer[] players = randomArray == 0 ? majors : minors;
        int randomIndex = rand.nextInt(players.length);
        currentSound = players[randomIndex];
        return currentSound;
    }

    public MediaPlayer getCurrentSound() {
        return currentSound;
    }


    public boolean isCurrentPerfect()
    {
        for (int i = 0; i<12; i++)
        {
            if (currentSound.equals(perfects[i])){
                return true;
            }
        }

        return false;
    }

    public boolean isCurrentMajor()
    {
        for (int i = 0; i<12; i++)
        {
            if (currentSound.equals(majors[i])){
                return true;
            }
        }

        return false;
    }

}
