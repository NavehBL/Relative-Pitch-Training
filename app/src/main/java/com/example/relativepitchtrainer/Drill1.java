package com.example.relativepitchtrainer;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Drill1 extends AppCompatActivity implements View.OnClickListener {

    public static final String SCORED1 = "SCORED1";
    public static final String TIMEAVRAGED1 = "TIMEAVRAGED1RE";
    public static final String NUMOFCORRECT = "NUMOFCORRECT";

    private Sounds sounds;
    static Context context;
    private MediaPlayer currentSound;
    private long startTime;
    private int questionsSum = 0, correctSum = 0, score = 0;
    private double timeAverage = 0;


    TextView tvNumOfQuestion, tvNumOfCorrect, tvTime, tvInstructions;
    Button btnP8Drill1, btnm3Drill1, btnReplayDrill1, btnNextDrill1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill1);



        sounds = new Sounds(this);

        tvNumOfQuestion = findViewById(R.id.tvNumOfQuestion);
        tvNumOfCorrect = findViewById(R.id.tvNumOfCorrect);
        tvTime = findViewById(R.id.tvTime);
        tvInstructions = findViewById(R.id.tvInstructions);

        btnP8Drill1 = findViewById(R.id.btnP8Drill1);
        btnP8Drill1.setOnClickListener(this);

        btnm3Drill1 = findViewById(R.id.btnm3Drill1);
        btnm3Drill1.setOnClickListener(this);

        btnReplayDrill1 = findViewById(R.id.btnReplayDrill1);
        btnReplayDrill1.setOnClickListener(this);

        btnNextDrill1 = findViewById(R.id.btnNextDrill1);
        btnNextDrill1.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        if(questionsSum == 5)
        {
            int scoreDrill1 = score;
            double timeAverageDrill1 = timeAverage;
            int numOfCorrect = correctSum;

            Intent intent = new Intent(this, ResultsD1.class);
            intent.putExtra(SCORED1, scoreDrill1);
            intent.putExtra(TIMEAVRAGED1, timeAverageDrill1);
            intent.putExtra(NUMOFCORRECT, numOfCorrect);
            startActivity(intent);
        }

            if (v == btnNextDrill1) {
                questionsSum++;
                tvNumOfQuestion.setText("Question: " + (questionsSum) + "/30 ");
                sounds.getRandomP8_m3();
                currentSound = sounds.getCurrentSound();
                currentSound.start();
                startTime = System.currentTimeMillis();
                tvInstructions.setText("What interval is this?");
                btnReplayDrill1.setClickable(true);
                btnNextDrill1.setClickable(false);

            }

            if (v == btnP8Drill1 || v == btnReplayDrill1 || v == btnm3Drill1) {

                if (v == btnReplayDrill1) {

                    currentSound.start();
                }


                if (v == btnP8Drill1) {
                    if (sounds.isCurrentPerfect()) {
                        correctSum++;
                        tvNumOfCorrect.setText("Correct: " + (correctSum) + "/" + questionsSum);
                        long endTime = System.currentTimeMillis();
                        double elapsedSeconds = (endTime - startTime) / 1000.0;
                        timeAverage = timeAverage + elapsedSeconds;
                        tvInstructions.setText("Correct! Tap 'Next' to continue");
                        btnNextDrill1.setClickable(true);
                        tvTime.setText("Time: " + (elapsedSeconds) + "s");
                        score = score + 10;

                    }
                    if (!sounds.isCurrentPerfect()) {
                        long endTime = System.currentTimeMillis();
                        double elapsedSeconds = (endTime - startTime) / 1000.0;
                        timeAverage = timeAverage + elapsedSeconds;
                        tvInstructions.setText("Wrong. the answer was m3.");
                        btnNextDrill1.setClickable(true);
                        tvNumOfCorrect.setText("Correct: " + (correctSum) + "/" + questionsSum);
                        tvTime.setText("Time: " + (elapsedSeconds) + "s");
                    }
                }

                if (v == btnm3Drill1) {
                    if (!sounds.isCurrentPerfect()) {
                        correctSum++;
                        tvNumOfCorrect.setText("Correct: " + (correctSum) + "/" + questionsSum);
                        long endTime = System.currentTimeMillis();
                        double elapsedSeconds = (endTime - startTime) / 1000.0;
                        timeAverage = timeAverage + elapsedSeconds;
                        tvInstructions.setText("Correct! Tap 'Next' to continue");
                        btnNextDrill1.setClickable(true);
                        tvTime.setText("Time: " + (elapsedSeconds) + "s");
                        score = score + 10;
                    }

                    if (sounds.isCurrentPerfect()) {
                        long endTime = System.currentTimeMillis();
                        double elapsedSeconds = (endTime - startTime) / 1000.0;
                        timeAverage = timeAverage + elapsedSeconds;
                        tvInstructions.setText("Wrong. the answer was P8.");
                        btnNextDrill1.setClickable(true);
                        tvNumOfCorrect.setText("Correct: " + (correctSum) + "/" + questionsSum);
                        tvTime.setText("Time: " + (elapsedSeconds) + "s");
                    }

                }
            }

        }


    }


