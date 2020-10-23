package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }


    //BUTTON: Open Student-to-Student Chat
    public void OpenStudentStudentChat(View view) {
        Intent OpenStudentStudentChat = new Intent(this, StudentStudentChat.class);
        startActivity(OpenStudentStudentChat);
    }


    //BUTTON: Open Student-to-Teacher Chat
    public void OpenTeacherStudentChat(View view) {
        Intent OpenTeacherStudentChat = new Intent(this, TeacherStudentChat.class);
        startActivity(OpenTeacherStudentChat);
    }


    //BUTTON: Open Teacher-to-Company Chat
    public void OpenTeacherCompanyChat(View view) {
        Intent OpenTeacherCompanyChat = new Intent(this, TeacherCompanyChat.class);
        startActivity(OpenTeacherCompanyChat);
    }

}