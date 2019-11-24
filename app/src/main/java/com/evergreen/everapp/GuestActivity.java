package com.evergreen.everapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

public class GuestActivity extends AppCompatActivity {

    private final TextView
        welcomeSign = findViewById(R.id.welcomeSign),
        msgBlock = findViewById(R.id.welcomeMsg);

    private final Button
        learnButton = findViewById(R.id.learnButton),
        contactButton = findViewById(R.id.contactButton),
        campButton = findViewById(R.id.campButton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        Animation fadeIn = new AlphaAnimation(0, 1);

        welcomeSign.startAnimation(fadeIn);
        msgBlock.startAnimation(fadeIn);
        learnButton.startAnimation(fadeIn);
        contactButton.startAnimation(fadeIn);
        campButton.startAnimation(fadeIn);


    }
}
