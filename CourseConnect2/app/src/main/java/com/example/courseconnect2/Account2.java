package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Account2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account2);
    }


    // BUTTON: Open Interests Page
    public void OpenInterests(View view) {
        Intent OpenInterests = new Intent(this, Interests.class);
        startActivity(OpenInterests); }


    // BUTTON: Open Change Username Page
    public void OpenChangeUsername(View view) {
        Intent OpenChangeUsername = new Intent(this, ChangeUsername.class);
        startActivity(OpenChangeUsername);
    }


    // BUTTON: Open Change Password Page
    public void OpenChangePassword(View view) {
        Intent OpenChangePassword = new Intent (this, ChangePassword.class);
        startActivity(OpenChangePassword);
    }


    // BUTTON: Open Change Email Page
    public void OpenChangeEmail(View view) {
        Intent OpenChangeEmail = new Intent (this, ChangeEmail.class);
        startActivity(OpenChangeEmail);
    }
}