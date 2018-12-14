package com.ics115.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SeatReservationActivity extends AppCompatActivity {

    private Spinner spinner2;
    private Button btnReserve;

//    Intent b = getIntent();
//    String id = b.getStringExtra("id");
//    TextView txtViewSet = (TextView) findViewById(R.id.txtViewSet);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_reservation);
//        txtViewSet.setText(id);
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
