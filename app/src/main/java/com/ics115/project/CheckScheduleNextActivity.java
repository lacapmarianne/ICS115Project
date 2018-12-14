package com.ics115.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CheckScheduleNextActivity extends AppCompatActivity {

    ImageView imgViewBus4, imgViewBus5, imgViewBus6;
    String bus_id;
    int CheckSeats = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_schedule_next);

        imgViewBus4 = (ImageView)findViewById(R.id.imgViewBus4);
        imgViewBus5 = (ImageView)findViewById(R.id.imgViewBus5);
        imgViewBus6 = (ImageView)findViewById(R.id.imgViewBus6);

        imgViewBus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bus_id == "4") {
                    imgViewBus4.setImageResource(R.drawable.bus_black);
                    bus_id = null;
                } else {
                    imgViewBus4.setImageResource(R.drawable.bus_orange);
                    imgViewBus5.setImageResource(R.drawable.bus_black);
                    imgViewBus6.setImageResource(R.drawable.bus_black);
                    bus_id = "4";
                }
                CheckSeats = R.id.imgViewBus4;
            }
        });

        imgViewBus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bus_id == "5") {
                    imgViewBus5.setImageResource(R.drawable.bus_black);
                    bus_id = null;
                } else {
                    imgViewBus4.setImageResource(R.drawable.bus_black);
                    imgViewBus5.setImageResource(R.drawable.bus_orange);
                    imgViewBus6.setImageResource(R.drawable.bus_black);
                    bus_id = "5";
                }
                CheckSeats = R.id.imgViewBus5;
            }
        });

        imgViewBus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bus_id == "6") {
                    imgViewBus6.setImageResource(R.drawable.bus_black);
                    bus_id = null;
                } else {
                    imgViewBus4.setImageResource(R.drawable.bus_black);
                    imgViewBus5.setImageResource(R.drawable.bus_black);
                    imgViewBus6.setImageResource(R.drawable.bus_orange);
                    bus_id = "6";
                }
                CheckSeats = R.id.imgViewBus6;
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

    public void prevSched(View view){
        Intent c = new Intent(getBaseContext(), CheckScheduleNextActivity.class);
        startActivity(c);
    }
}
