package com.example.courseconnect2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
    }


    //BUTTON: Open Setting Page
    public void OpenSettings(View view) {
        Intent OpenSettings = new Intent(this, Settings.class);
        startActivity(OpenSettings);
    }


    //BUTTON: Open MyCourses Page
    public void OpenMyCourses(View view) {
        Intent OpenMyCourses = new Intent(this, MyCourses.class);
        startActivity(OpenMyCourses);
    }


    //BUTTON: Open Courses Page
    public void OpenCourse(View view) {
        Intent OpenCourse = new Intent (this, Course.class);
        startActivity(OpenCourse);
    }


    //BUTTON: Open Chat Page
    public void OpenChat(View view) {
        Intent OpenChat = new Intent (this, Chat.class);
        startActivity(OpenChat);
    }
}
