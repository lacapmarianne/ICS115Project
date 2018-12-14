package com.ics115.project;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public void LoginUser(View v) {
        EditText userName, userPass;

        userName = (EditText) findViewById(R.id.editTxtResName);
        userPass = (EditText) findViewById(R.id.editTxtBookNum);

        String username = userName.getText().toString();
        String concat;
        concat = "@gmail.com";

        String finalString =  username + concat;

        String password = userPass.getText().toString();
        mAuth.signInWithEmailAndPassword(finalString, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // Sign in Success
                            Log.d("4ITF", "signInWithUserName:success");

                            Intent s = new Intent(getBaseContext(), WelcomePageActivity.class);
                            startActivity(s);

                        } else {

                            // Sign in Fails
                            Log.w("4ITF", "signInWithUserName:failure", task.getException());

                            Intent f = new Intent(getBaseContext(), LoginFailedActivity.class);
                            startActivity(f);

                        }
                    }

                });
    }
}
