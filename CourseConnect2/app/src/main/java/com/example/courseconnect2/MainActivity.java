package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import static java.lang.String.*;

public class MainActivity extends AppCompatActivity {

    public static String UserNameOllie;

    private EditText Name;
    private EditText Password;
    private Button Login;

    DataBaseHelper mDataBaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataBaseHelper = new DataBaseHelper(this);

        Name = (EditText)findViewById(R.id.idUsername);
        Password = (EditText)findViewById(R.id.idPassword);
        Login = (Button)findViewById(R.id.idLogin);
    }


    // BUTTON: Try to Login (and when successful open the Dashboard)
    public void LoginActie(View view) {
        String givenName = Name.getText().toString();
        String givenPassword = Password.getText().toString();

        String testPassword = mDataBaseHelper.getPassword(givenName);
        if(givenPassword.equals(testPassword)) {
            toastMessage(String.format("Welcome %s", givenName));

            Intent intent = new Intent(this, Dashboard2.class);
            startActivity(intent);
            UserNameOllie = givenName;
        }else{
            toastMessage(String.format("This combination does not exist"));
        }
    }

    
    // SETTER: UserNameOllie
    public static void ChangeUserNameOllie(String newName) {
        UserNameOllie = newName;
    }


    // BUTTON: Open the RegisterPage
    public void OpenRegisterPage(View view) {
        Intent ORP = new Intent(this, RegisterPage.class);
        startActivity(ORP);
    }


    // Message Display
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
