package com.ics115.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginFailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_failed);
    }

    public void LoginClick(View view) {
        Intent f = new Intent(getBaseContext(), LoginActivity.class);
        startActivity(f);
    }
}
