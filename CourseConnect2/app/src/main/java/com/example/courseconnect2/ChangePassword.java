package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    DataBaseHelper mDataBaseHelper;
    private EditText NewPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        mDataBaseHelper = new DataBaseHelper(this);
        NewPassword = (EditText)findViewById(R.id.NewPassWord);
    }


    //BUTTON: Change Password
    public void ClickOnChangePassword(View view) {
        String newPw = NewPassword.getText().toString();

        String UserID = mDataBaseHelper.getUserID(MainActivity.UserNameOllie);
        toastMessage(String.format("Password of User '%s' Changed!", UserID));
        mDataBaseHelper.setPassword(UserID, newPw);
    }


    // Message Display
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}