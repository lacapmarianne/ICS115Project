package com.ics115.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SeatReservationActivity extends AppCompatActivity {

    private Spinner spinner2;
    private Button btnReserve;
    DatabaseReference myRef;
    FirebaseDatabase database;
    ImageView imageViewSeat1;
//    Intent b = getIntent();
//    String id = b.getStringExtra("id");
//    TextView txtViewSet = (TextView) findViewById(R.id.txtViewSet);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_reservation);
//        txtViewSet.setText(id);
        imageViewSeat1 = findViewById(R.id.imageViewSeat1);

        database = FirebaseDatabase.getInstance();

            addItemsOnSpinner2();
            addListenerOnButton();
    }

    // Add items into spinner dynamically
    public void addItemsOnSpinner2(){
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("7:00AM to 9:00AM");
        list.add("10:00AM to 12:00NN");
        list.add("1:00PM to 3:00PM");
        list.add("4:00PM to 6:00PM");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnReserve = (Button) findViewById(R.id.btnReserve);

        imageViewSeat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 1").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 1").getRef().setValue(true);


                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 1").getRef().setValue(false);

                        }
                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 1 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btnReserve.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Toast.makeText(SeatReservationActivity.this,
                                "\nYou've selected: "+ String.valueOf(spinner2.getSelectedItem()),
                                Toast.LENGTH_SHORT).show();
            }

        });
    }

}
