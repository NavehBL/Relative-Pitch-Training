package com.example.relativepitchtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Drill2 extends AppCompatActivity implements View.OnClickListener {

    private Sounds sounds;
    private MediaPlayer currentSound;
    private long startTime;
    private int questionsSum = 0, correctSum = 0, score = 0;


    TextView tvNumOfQuestion2, tvNumOfCorrect2, tvTime2, tvInstructions2;
    Button btnM3Drill2, btnm3Drill2, btnReplayDrill2, btnNextDrill2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill2);



        sounds = new Sounds(this);

        tvNumOfQuestion2 = findViewById(R.id.tvNumOfQuestion2);
        tvNumOfCorrect2 = findViewById(R.id.tvNumOfCorrect2);
        tvTime2 = findViewById(R.id.tvTime2);
        tvInstructions2 = findViewById(R.id.tvInstructions2);

        btnM3Drill2 = findViewById(R.id.btnM3Drill2);
        btnM3Drill2.setOnClickListener(this);

        btnm3Drill2 = findViewById(R.id.btnm3Drill2);
        btnm3Drill2.setOnClickListener(this);

        btnReplayDrill2 = findViewById(R.id.btnReplayDrill2);
        btnReplayDrill2.setOnClickListener(this);

        btnNextDrill2 = findViewById(R.id.btnNextDrill2);
        btnNextDrill2.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if(questionsSum == 5)
        {
            Intent intent = new Intent(this, ResultsD1.class);
            startActivity(intent);
        }

        if (v == btnNextDrill2) {
            questionsSum++;
            tvNumOfQuestion2.setText("Question: " + (questionsSum) + "/30 ");
            sounds.getRandomM3_m3();
            currentSound = sounds.getCurrentSound();
            currentSound.start();
            startTime = System.currentTimeMillis();
            tvInstructions2.setText("What interval is this?");
            btnReplayDrill2.setClickable(true);
            btnNextDrill2.setClickable(false);

        }

        if (v == btnM3Drill2 || v == btnReplayDrill2 || v == btnm3Drill2) {

            if (v == btnReplayDrill2) {

                currentSound.start();
            }


            if (v == btnM3Drill2) {
                if (sounds.isCurrentMajor()) {
                    correctSum++;
                    tvNumOfCorrect2.setText("Correct: " + (correctSum) + "/" + questionsSum);
                    long endTime = System.currentTimeMillis();
                    double elapsedSeconds = (endTime - startTime) / 1000.0;
                    tvInstructions2.setText("Correct! Tap 'Next' to continue");
                    btnNextDrill2.setClickable(true);
                    tvTime2.setText("Time: " + (elapsedSeconds) + "s");
                    score = score + 10;

                }
                if (!sounds.isCurrentMajor()) {
                    long endTime = System.currentTimeMillis();
                    double elapsedSeconds = (endTime - startTime) / 1000.0;
                    tvInstructions2.setText("Wrong. the answer was m3.");
                    btnNextDrill2.setClickable(true);
                    tvNumOfCorrect2.setText("Correct: " + (correctSum) + "/" + questionsSum);
                    tvTime2.setText("Time: " + (elapsedSeconds) + "s");
                }
            }

            if (v == btnm3Drill2) {
                if (!sounds.isCurrentMajor()) {
                    correctSum++;
                    tvNumOfCorrect2.setText("Correct: " + (correctSum) + "/" + questionsSum);
                    long endTime = System.currentTimeMillis();
                    double elapsedSeconds = (endTime - startTime) / 1000.0;
                    tvInstructions2.setText("Correct! Tap 'Next' to continue");
                    btnNextDrill2.setClickable(true);
                    tvTime2.setText("Time: " + (elapsedSeconds) + "s");
                    score = score + 10;
                }

                if (sounds.isCurrentMajor()) {
                    long endTime = System.currentTimeMillis();
                    double elapsedSeconds = (endTime - startTime) / 1000.0;
                    tvInstructions2.setText("Wrong. the answer was P8.");
                    btnNextDrill2.setClickable(true);
                    tvNumOfCorrect2.setText("Correct: " + (correctSum) + "/" + questionsSum);
                    tvTime2.setText("Time: " + (elapsedSeconds) + "s");
                }

            }
        }

    }


}
