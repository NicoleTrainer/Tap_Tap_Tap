package com.ntrainer.taptaptap;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class gamePlay extends AppCompatActivity {

    int choice = 0;
    private View main;
    int taps=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        TextView timer = findViewById(R.id.timeRemaining);
        TextView tapCount = findViewById(R.id.tapcount);
        main = findViewById(R.id.actgame);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                taps++;
                tapCount.setText("Taps: " + taps);
            }
        });
        Intent intent = getIntent();
        choice = intent.getIntExtra("choice", 0);
        timer(choice, timer);



    }

    public  void timer(int choice, TextView timer){

        long time = choice * 1000L;
        CountDownTimer countDownTimer;



        countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long l) {
                long seconds = l / 1000;
                timer.setText(String.valueOf(seconds));
            }

            @Override
            public void onFinish() {
                timer.setText(String.valueOf(0));
                startNewActivity();
            }
        };

        countDownTimer.start();
    }

    private void startNewActivity() {
        Intent intent = new Intent(gamePlay.this, endGame.class );
        intent.putExtra("taps", taps);
        intent.putExtra("choice", choice);
        startActivity(intent);
    }


    }

