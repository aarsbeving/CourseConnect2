package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Course extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }


    //BUTTON: Buy Course
    public void BuyCourse(View view) {
        toastMessages(String.format("Course has been bought"));
    }


    //BUTTON: Share Course
    public void ShareCourse(View view) {
        toastMessages(String.format("The course has been shared"));
    }


    // Message Display
    public void toastMessages(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}