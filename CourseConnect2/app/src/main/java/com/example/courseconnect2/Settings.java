package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    // BUTTON: Open Account Setting Page
    public void OpenAccount(View view) {
        Intent OpenAccount = new Intent(this, Account2.class);
        startActivity(OpenAccount);
    }
}