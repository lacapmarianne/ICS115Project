package com.ics115.project;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SeatReservationActivity extends AppCompatActivity {

    private Spinner spinner2;
    private Button btnReserve;
    String seat_id;

    DatabaseReference myRef;
    FirebaseDatabase database;

    ImageView imageViewSeat1,imageViewSeat2,imageViewSeat3,imageViewSeat4,imageViewSeat5,
            imageViewSeat6, imageViewSeat7, imageViewSeat8, imageViewSeat9, imageViewSeat10,
            imageViewSeat11, imageViewSeat12, imageViewSeat13, imageViewSeat14, imageViewSeat15,
            imageViewSeat16, imageViewSeat17, imageViewSeat18, imageViewSeat19, imageViewSeat20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_reservation);

        imageViewSeat1 = findViewById(R.id.imageViewSeat1);
        imageViewSeat2 = findViewById(R.id.imageViewSeat2);
        imageViewSeat3 = findViewById(R.id.imageViewSeat3);
        imageViewSeat4 = findViewById(R.id.imageViewSeat4);
        imageViewSeat5 = findViewById(R.id.imageViewSeat5);
        imageViewSeat6 = findViewById(R.id.imageViewSeat6);
        imageViewSeat7 = findViewById(R.id.imageViewSeat7);
        imageViewSeat8 = findViewById(R.id.imageViewSeat8);
        imageViewSeat9 = findViewById(R.id.imageViewSeat9);
        imageViewSeat10 = findViewById(R.id.imageViewSeat10);
        imageViewSeat11 = findViewById(R.id.imageViewSeat11);
        imageViewSeat12 = findViewById(R.id.imageViewSeat12);
        imageViewSeat13 = findViewById(R.id.imageViewSeat13);
        imageViewSeat14 = findViewById(R.id.imageViewSeat14);
        imageViewSeat15 = findViewById(R.id.imageViewSeat15);
        imageViewSeat16 = findViewById(R.id.imageViewSeat16);
        imageViewSeat17 = findViewById(R.id.imageViewSeat17);
        imageViewSeat18 = findViewById(R.id.imageViewSeat18);
        imageViewSeat19 = findViewById(R.id.imageViewSeat19);
        imageViewSeat20 = findViewById(R.id.imageViewSeat20);

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

    // Get the selected dropdown list value
    public void addListenerOnButton() {

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        btnReserve = (Button) findViewById(R.id.btnReserve);

        //Reservation for Seat 1
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

                        if(seat_id == "Seat 1") {
                            imageViewSeat1.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        }else{
                            imageViewSeat1.setImageResource(R.drawable.seat_orange);
                        }

                        Toast.makeText(SeatReservationActivity.this, "Seat 1 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 2
        imageViewSeat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 2").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 2").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 2").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 2") {
                            imageViewSeat2.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        }else{
                            imageViewSeat2.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 2 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 3
        imageViewSeat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 3").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 3").getRef().setValue(true);


                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 3").getRef().setValue(false);

                        }
                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 3") {
                            imageViewSeat3.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat3.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 3 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 4
        imageViewSeat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 4").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 4").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 4").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 4") {
                            imageViewSeat4.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat4.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 4 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 5
        imageViewSeat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 5").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 5").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 5").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 5") {
                            imageViewSeat5.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat5.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 5 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 6
        imageViewSeat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 6").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 6").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 6").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 6") {
                            imageViewSeat6.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat6.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this,  "Seat 6 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 7
        imageViewSeat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 7").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 7").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 7").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 7") {
                            imageViewSeat7.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat7.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 7 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 8
        imageViewSeat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 8").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 8").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 8").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 8") {
                            imageViewSeat8.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat8.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 8 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 9
        imageViewSeat9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 9").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 9").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 9").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }
                        if(seat_id == "Seat 9") {
                            imageViewSeat9.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat9.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 9 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 10
        imageViewSeat10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 10").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 10").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 10").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 10") {
                            imageViewSeat10.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat10.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 10 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 11
        imageViewSeat11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 11").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 11").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 11").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 11") {
                            imageViewSeat11.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat11.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 11 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 12
        imageViewSeat10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 10").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 10").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 10").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 12") {
                            imageViewSeat12.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat12.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 12 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 13
        imageViewSeat13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 13").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 13").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 13").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 13") {
                            imageViewSeat13.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat13.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 13 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 14
        imageViewSeat14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 14").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 14").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 14").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 14") {
                            imageViewSeat14.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat14.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 14 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 15
        imageViewSeat15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 15").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 15").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 15").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 15") {
                            imageViewSeat15.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat15.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this,  "Seat 15 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 16
        imageViewSeat16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 16").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 16").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 16").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 16") {
                            imageViewSeat16.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat16.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 16 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 17
        imageViewSeat17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 17").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 17").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 17").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 17") {
                            imageViewSeat17.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat17.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 17 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 18
        imageViewSeat18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 18").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 18").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 18").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 18") {
                            imageViewSeat18.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat18.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 18 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 19
        imageViewSeat19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 19").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 19").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 19").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 19") {
                            imageViewSeat19.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat19.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 19 is " + status, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Reservation for Seat 20
        imageViewSeat20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = database.getReference(String.valueOf(spinner2.getSelectedItem()));
                myRef.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                        Boolean value = dataSnapshot.child("Seat 20").getValue(Boolean.class);
                        String status;
                        if(value.equals(false)){
                            dataSnapshot.child("Seat 20").getRef().setValue(true);
                        }else if(value.equals(true)){
                            dataSnapshot.child("Seat 20").getRef().setValue(false);
                        }

                        if(value.equals(true)){
                            status = "vacant";
                        }else{
                            status = "reserved";
                        }

                        if(seat_id == "Seat 20") {
                            imageViewSeat20.setImageResource(R.drawable.seat_black);
                            seat_id = null;
                        } else{
                            imageViewSeat20.setImageResource(R.drawable.seat_orange);
                        }
                        Toast.makeText(SeatReservationActivity.this, "Seat 20 is " + status, Toast.LENGTH_SHORT).show();
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
