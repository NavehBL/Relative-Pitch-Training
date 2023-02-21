package com.example.relativepitchtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTheory, btnDrill1, btnDrill2, btnDrill3;

    TextView tvTitle, tvScore;

    Menu menu;

    MenuItem item;
    int score = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int scoreFromD1 = intent.getIntExtra(Drill1.SCORED1, 0);
        tvScore.setText(scoreFromD1);
        score = score + scoreFromD1;

        tvScore = findViewById(R.id.tvScore);

        tvTitle = findViewById(R.id.tvTitle);

        btnTheory = findViewById(R.id.btnTheory);
        btnTheory.setOnClickListener(this);

        btnDrill1 = findViewById(R.id.btnDrill1);
        btnDrill1.setOnClickListener(this);

        btnDrill2 = findViewById(R.id.btnDrill2);
        btnDrill2.setOnClickListener(this);

        btnDrill3 = findViewById(R.id.btnDrill3);
        btnDrill3.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if(v == btnTheory){
            Intent intent = new Intent(this, Theory.class);
            startActivity(intent);
        }

        if(v == btnDrill1){
            Intent intent = new Intent(this, Drill1.class);
            startActivity(intent);
        }

        if(v == btnDrill2){
            Intent intent = new Intent(this, Drill2.class);
            startActivity(intent);
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item1:
                Intent intent = new Intent(this, Theory.class);
                startActivity(intent);
            case R.id.menu_item2:
                // Handle menu item 2 click
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}