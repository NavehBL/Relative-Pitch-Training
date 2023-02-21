package com.example.relativepitchtrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Theory extends AppCompatActivity implements View.OnClickListener{



    private Sounds sounds;
    Button btnM3Example, btnm3Example, btnP8Theory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory);

        sounds = new Sounds(this);

        btnM3Example = findViewById(R.id.btnM3Example);
        btnM3Example.setOnClickListener(this);


        btnm3Example = findViewById(R.id.btnm3Example);
        btnm3Example.setOnClickListener(this);

        btnP8Theory = findViewById(R.id.btnP8Theory);
        btnP8Theory.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        if(view == btnM3Example)
        {
            MediaPlayer player = sounds.getRandomMajor();
            player.start();
        }

        if(view == btnm3Example)
        {
            MediaPlayer player = sounds.getRandomMinors();
            player.start();
        }

        if(view == btnP8Theory)
        {
            MediaPlayer player = sounds.getRandomPerfects();
            player.start();
        }

    }


}
