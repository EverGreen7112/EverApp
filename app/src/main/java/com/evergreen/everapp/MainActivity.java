package com.evergreen.everapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;

import com.evergreen.everapp.guest.GuestActivity;
import com.evergreen.everapp.member.Login;

public class MainActivity extends AppCompatActivity {


    //To keep what they chose -
    private final SharedPreferences m_typePref =
            //A shared preference sustains after app close.
            getSharedPreferences("User Type", Context.MODE_PRIVATE);
    //This is like a preferences dictionary - you can store values by keys.


    private static final String TYPE_KEY = "userType"; //

    private final Context m_this = this;

    private static final int TYPE_UNKNOWN = 0;
    private static final int TYPE_MEMBER = 1;
    private static final int TYPE_GUEST = 2;

    private final Button memberButton = findViewById(R.id.memberButton);
    private final Button guestButton = findViewById(R.id.guestButton);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (getUserType()) {
            case TYPE_GUEST:
                startActivity(new Intent(this, GuestActivity.class));
                break;

            case TYPE_MEMBER:
                startActivity(new Intent(this, Login.class));
                break;
        }

        setContentView(R.layout.activity_main);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1500);

        memberButton.startAnimation(fadeIn);
        guestButton.startAnimation(fadeIn);

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUserType(TYPE_MEMBER);
                startActivity(new Intent(m_this, MainActivity.class));    }
        });

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setUserType(TYPE_MEMBER);
                startActivity(new Intent(m_this, Login.class));    }
        });
    }

    private int getUserType() {
        return m_typePref.getInt(TYPE_KEY, TYPE_UNKNOWN);
    }

    private void setUserType(int type) {
        SharedPreferences.Editor setter = m_typePref.edit();
        setter.putInt(TYPE_KEY, type);
        setter.apply();
    }
}
