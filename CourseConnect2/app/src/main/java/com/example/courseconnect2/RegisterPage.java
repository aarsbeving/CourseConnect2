package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Switch;


public class RegisterPage extends AppCompatActivity {

    private EditText UserName;
    private EditText Email;
    private EditText Password;
    public static String EmailOllie;
    public Switch Teacher;

    DataBaseHelper mDataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        mDataBaseHelper = new DataBaseHelper(this);

        UserName = (EditText)findViewById(R.id.idRegName);
        Email = (EditText)findViewById(R.id.idRegMail);
        Password = (EditText)findViewById(R.id.idRegPass);
        Teacher = (Switch) findViewById(R.id.TeacherSwitch);
    }


    // BUTTON: Try to register (when successful open Dashboard)
    public void RegisterActie(View view) {
        String givenName = UserName.getText().toString();
        String givenPassword = Password.getText().toString();
        String givenMail = Email.getText().toString();
        Switch Teacher = (Switch) findViewById(R.id.TeacherSwitch);
        String giveTeach = "";
        if (Teacher.isChecked()) {
            giveTeach = "1";
        }else{
            giveTeach = "0";
        }
        String givenTeach = giveTeach;
        EmailOllie = givenMail;

        if(mDataBaseHelper.testName(givenName)) {
            mDataBaseHelper.addData(givenName, givenPassword, givenMail, givenTeach);
            toastMessage("Account Successfully created!");

            Intent OpenDB = new Intent(this, Dashboard2.class);
            startActivity(OpenDB);
            MainActivity.UserNameOllie = givenName;
        }else{
            toastMessage(String.format("Unfortunately the username '%s' is already in use", givenName));
        }
    }


    // Message Display
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}