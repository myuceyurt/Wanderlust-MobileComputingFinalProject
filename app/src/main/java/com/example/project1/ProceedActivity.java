package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ProceedActivity extends AppCompatActivity {
    private int counter = 0;
    private TextView checkoutText;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_proceed);

        progressBar = findViewById(R.id.progressBar);
        checkoutText = findViewById(R.id.checkoutText);
        Timer t  = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter = counter + 2;
                progressBar.setProgress(counter);

                if(counter == 100){
                    checkoutText.setText("Enjoy your trip :)");
                }
                if(counter == 160) {
                    t.cancel();
                    Intent i = new Intent(ProceedActivity.this,MainScreen.class);
                    startActivity(i);
                }
            }
        };
        t.schedule(tt,0,100);


    }
}