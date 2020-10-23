package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeEmail extends AppCompatActivity {

    DataBaseHelper mDataBaseHelper;
    private EditText NewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        NewEmail = (EditText)findViewById(R.id.newEMail);

        mDataBaseHelper = new DataBaseHelper(this);
    }


    // BUTTON: Change Email
    public void ClickOnChangeEmail(View view) {
        String newEm = NewEmail.getText().toString();

        String UserID = mDataBaseHelper.getUserID(MainActivity.UserNameOllie);
        toastMessage(String.format("Email of User '%s' Changed!", UserID));
        mDataBaseHelper.setEmail(UserID, newEm);
    }


    // Message Display
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}