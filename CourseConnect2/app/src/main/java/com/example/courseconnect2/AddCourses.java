package com.example.courseconnect2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Helper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.courseconnect2.MainActivity.UserNameOllie;

public class AddCourses extends AppCompatActivity {

    CourseDataHelper HelperHarry;
    DataBaseHelper mDataBaseHelper;

    private EditText Name;
    private EditText Costs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_courses);

        HelperHarry = new CourseDataHelper(this);
        mDataBaseHelper = new DataBaseHelper(this);

        Name = (EditText)findViewById(R.id.FillName);
        Costs = (EditText)findViewById(R.id.FillCosts);
    }


    // Button: Adds Course to the Course Database
    public void RegisterActie(View view) {
        String testTeacher = mDataBaseHelper.getTeacher(UserNameOllie);
        String givenName = Name.getText().toString();
        String givenCosts = Costs.getText().toString();

        if(testTeacher.equals("1")){
            if(HelperHarry.testName(givenName)) {
                HelperHarry.addCourseData(givenName, givenCosts);
                toastMessage("Data (Successfully) Inserted!");

                Intent WouterBerendFaxSchuit = new Intent(this, MyCourses.class);
                startActivity(WouterBerendFaxSchuit);
            }else{
                toastMessage(String.format("Unfortunately the username '%s' is already in use", givenName));
            }
        }else{
            toastMessage(String.format("You cannot make an course, because you are not an teacher"));
        }

    }


    // Message Display
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}