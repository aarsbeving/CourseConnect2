package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangeUsername extends AppCompatActivity {

    DataBaseHelper mDataBaseHelper;
    private EditText NewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_username);

        NewUsername = (EditText)findViewById(R.id.NewUserName);

        mDataBaseHelper = new DataBaseHelper(this);
    }


    //BUTTON: Change Name
    public void ClickOnChangeUsername(View view) {
        String newName = NewUsername.getText().toString();
        String oldName = MainActivity.UserNameOllie;

        String UserID = mDataBaseHelper.getUserID(oldName);
        toastMessage(String.format("Username of User '%s' Changed from '%s' to '%s'!", UserID, oldName, newName));
        mDataBaseHelper.setName(UserID, newName);
        MainActivity.ChangeUserNameOllie(newName);
    }


    // Message Display
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}