package com.ics115.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ReservedSeatsActivity extends AppCompatActivity {
    Button btnHome;
    TextView seats;
    TextView time;
    TextView bNumber;
    TextView rName;
    String name;
    int bNum;
    Date currentTime = Calendar.getInstance().getTime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_seats);
        btnHome = findViewById(R.id.btnHome);
        seats = findViewById(R.id.seats);
        time = findViewById(R.id.timestamp);
        rName = findViewById(R.id.reserveName);
        bNumber = findViewById(R.id.bNumber);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm a");
// you can get seconds by adding  "...:ss" to it
        date.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

        String localTime = date.format(currentLocalTime);
        rName.setText(LoginActivity.getName());
        bNumber.setText(LoginActivity.getNumber());
        seats.setText(""+ SeatReservationActivity.getReserved());
        time.setText(localTime);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome(v);
            }
        });



    }

    public void goHome(View view){
        Intent g = new Intent(ReservedSeatsActivity.this,WelcomePageActivity.class);
        startActivity(g);
    }
}
