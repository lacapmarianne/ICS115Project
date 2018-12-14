package com.ics115.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CheckScheduleActivity extends AppCompatActivity {

    ImageView imgViewBus1, imgViewBus2, imgViewBus3;
    String bus_id;
    int CheckSeats = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_schedule);

        imgViewBus1 = (ImageView)findViewById(R.id.imgViewBus1);
        imgViewBus2 = (ImageView)findViewById(R.id.imgViewBus2);
        imgViewBus3 = (ImageView)findViewById(R.id.imgViewBus3);

        imgViewBus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bus_id == "1") {
                    imgViewBus1.setImageResource(R.drawable.bus_black);
                    bus_id = null;
                } else {
                    imgViewBus1.setImageResource(R.drawable.bus_orange);
                    imgViewBus2.setImageResource(R.drawable.bus_black);
                    imgViewBus3.setImageResource(R.drawable.bus_black);
                    bus_id = "1";
                }
                CheckSeats = R.id.imgViewBus1;
            }
        });

        imgViewBus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bus_id == "2") {
                    imgViewBus2.setImageResource(R.drawable.bus_black);
                    bus_id = null;
                } else {
                    imgViewBus1.setImageResource(R.drawable.bus_black);
                    imgViewBus2.setImageResource(R.drawable.bus_orange);
                    imgViewBus3.setImageResource(R.drawable.bus_black);
                    bus_id = "2";
                }
                CheckSeats = R.id.imgViewBus2;
            }
        });

        imgViewBus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bus_id == "3") {
                    imgViewBus3.setImageResource(R.drawable.bus_black);
                    bus_id = null;
                } else {
                    imgViewBus1.setImageResource(R.drawable.bus_black);
                    imgViewBus2.setImageResource(R.drawable.bus_black);
                    imgViewBus3.setImageResource(R.drawable.bus_orange);
                    bus_id = "3";
                }
                CheckSeats = R.id.imgViewBus3;
            }
        });
    }

    public void checkSeats(View view) {

        Toast.makeText(this, "You've chosen " + bus_id + " to check seats from.", Toast.LENGTH_SHORT).show();

        if(bus_id !=  null) {
            Intent b = new Intent(getBaseContext(), SeatReservationActivity.class);
            b.putExtra("id", bus_id);
            startActivity(b);
        } else {
            Toast.makeText(this, "You haven't chose any bus yet.", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextSched(View view){
        Intent c = new Intent(getBaseContext(), CheckScheduleNextActivity.class);
        startActivity(c);
    }
}
