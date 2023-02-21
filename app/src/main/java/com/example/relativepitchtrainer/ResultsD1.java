package com.example.relativepitchtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class ResultsD1 extends AppCompatActivity implements View.OnClickListener {

    TextView tvScoreResD1, tvTimeBonusResD1, tvTotalScoreResD1, tvCorrectAnswerResD1, tvTimeAverageResD1;
    ImageButton btnBackResD1, btnRetryResD1, btnNextResD1;
    double idealTime = 8.000;
    int timeBonus = 0, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_d1);

        Intent intent = getIntent();
        int scoreD1 = intent.getIntExtra(Drill1.SCORED1, 0);
        double timeAverageD1 = intent.getDoubleExtra(Drill1.TIMEAVRAGED1, 0);
        int numOfCorrectD1 = intent.getIntExtra(Drill1.NUMOFCORRECT, 0);
        timeAverageD1 /= 30;

        tvScoreResD1 = findViewById(R.id.tvScoreResD1);
        tvTimeBonusResD1 = findViewById(R.id.tvTimeBonusResD1);
        tvTotalScoreResD1 = findViewById(R.id.tvTotalScoreResD1);
        tvCorrectAnswerResD1 = findViewById(R.id.tvCorrectAnswerResD1);
        tvTimeAverageResD1 = findViewById(R.id.tvTimeAverageResD1);

        btnBackResD1 = findViewById(R.id.btnBackResD1);
        btnBackResD1.setOnClickListener(this);
        btnRetryResD1 = findViewById(R.id.btnRetryResD1);
        btnRetryResD1.setOnClickListener(this);
        btnNextResD1 = findViewById(R.id.btnNextResD1);
        btnNextResD1.setOnClickListener(this);



       tvScoreResD1.setText(scoreD1);

        if(timeAverageD1<idealTime)
            timeBonus = 100;

        tvTimeBonusResD1.setText(timeBonus);

        tvTotalScoreResD1.setText(scoreD1+timeBonus);

        tvCorrectAnswerResD1.setText(numOfCorrectD1 + "/30");

        tvTimeAverageResD1.setText(timeAverageD1 + "/" + idealTime);

        score = scoreD1;
    }

    @Override
    public void onClick(View v) {
        if (v == btnBackResD1)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (v == btnRetryResD1)
        {
            Intent intent = new Intent(this, Drill1.class);
            startActivity(intent);
        }
        if (v == btnNextResD1)
        {
            Intent intent = new Intent(this, Drill2.class);
            startActivity(intent);
        }

    }
}