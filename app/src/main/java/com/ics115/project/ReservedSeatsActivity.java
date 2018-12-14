package com.ics115.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ReservedSeatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_seats);
    }

    public void goHome(View view){
        Intent g = new Intent(getBaseContext(),WelcomePageActivity.class);
        startActivity(g);
    }
}
