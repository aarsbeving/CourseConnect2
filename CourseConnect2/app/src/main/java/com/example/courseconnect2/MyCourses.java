package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyCourses extends AppCompatActivity {

    CourseDataHelper HelperHarry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_courses);

        HelperHarry = new CourseDataHelper(this);
    }


    // BUTTON: Open Add Course Page
    public void OpenAddCourses(View view) {
        Intent OpenAddCourses = new Intent(this, AddCourses.class);
        startActivity(OpenAddCourses);
    }


    // BUTTON: Prints Course Information(name, teacher & cost) on Screen
    public void UpdateCourse(View view) {
        String FinalString = "";
        String CourseAmount = HelperHarry.getCourseAmount();

        int counter = Integer.parseInt(CourseAmount);

        while (counter != 0) {
            String CounterString = Integer.toString(counter);
            String CourseName = HelperHarry.getCourseName(CounterString);
            String CourseTeacher = HelperHarry.getCourseTeacher(CounterString);
            String CourseCost = HelperHarry.getCourseCost(CounterString);

            FinalString = FinalString + String.format("Name: %s\n", CourseName);
            FinalString = FinalString + String.format("Teacher: %s\n", CourseTeacher);
            FinalString = FinalString + String.format("Cost: %s\n", CourseCost);
            FinalString = FinalString + String.format("\n");
            counter--;
        }

        TextView textElement = (TextView) findViewById(R.id.CorsList);
        textElement.setText(FinalString);
    }
}