package com.example.rockpaperscissors_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RockPaperScissors extends AppCompatActivity {
    private TextView countdownText;
    private Button countdownButton;

    private CountDownTimer countDownTimer;
    private long timeLeftinMilliseconds = 4000; //4 seconds
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        countdownText = findViewById(R.id.countdown_text);
        countdownButton = findViewById(R.id.countdown_button);

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });
    }

    public void startStop() {
        if (timerRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftinMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftinMilliseconds = l;
                updateTimer();
            }
            @Override
            public void onFinish() {

            }
        }.start();

        countdownButton.setText("PAUSE");
        timerRunning = true;
    }

    public void stopTimer() {
        countDownTimer.cancel();
        countdownButton.setText("START");
        timerRunning = false;
    }

    public void updateTimer() {

        int seconds = (int) timeLeftinMilliseconds % 60000 / 1000;

        String timeLeftText = "" + seconds;
        if (seconds==3) {
            timeLeftText = "Rock";
            countdownText.setText(timeLeftText);
        }
        else if (seconds==2) {
            timeLeftText = "Paper";
            countdownText.setText(timeLeftText);
        }
        else if (seconds==1) {
            timeLeftText = "Scissors";
            countdownText.setText(timeLeftText);
        }
        else if (seconds==0) {
            timeLeftText = "Shoot";
            countdownText.setText(timeLeftText);
        }


    }
}
