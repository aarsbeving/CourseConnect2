package com.example.courseconnect2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CourseDataHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "course_table";
    public static final String TAG = "CourseDataHelper";

    public static final String COLUMN_COURSE_NAME = "COURSE_NAME";
    public static final String COLUMN_COURSE_TEACHER = "COURSE_TEACHER";;
    public static final String COLUMN_COURSE_COSTS = "COURSE_COSTS";;
    public static final String COLUMN_COURSE_ID = "rowid";

    public CourseDataHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable;
        createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_COURSE_NAME + " TEXT, " + COLUMN_COURSE_TEACHER + " TEXT, " + COLUMN_COURSE_COSTS + " INT)";
        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    // Tests if CourseName already exists
    public boolean testName(String CourseName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_COURSE_COSTS + " FROM " + TABLE_NAME + " WHERE " + COLUMN_COURSE_NAME + " = '" + CourseName + "'";
        Cursor data = db.rawQuery(query, null);
        if (data.moveToFirst()) {
            return false;
        }else{
            return true;
        }
    }


    // SETTER Add Data to the Database
    public void addCourseData(String name, String costs) {
        SQLiteDatabase db = this.getWritableDatabase();
        String teacher = MainActivity.UserNameOllie;
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COURSE_NAME, name);
        contentValues.put(COLUMN_COURSE_TEACHER, teacher);
        contentValues.put(COLUMN_COURSE_COSTS, costs);

        Log.d(TAG, "addData: Adding " + name + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + teacher + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + costs + " to " + TABLE_NAME);

        db.insert(TABLE_NAME, null, contentValues);
    }


    // GETTERS


    // GETTER Course Amount
    public String getCourseAmount() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query9 = "SELECT COUNT(*) FROM " + TABLE_NAME;;
        Cursor data = db.rawQuery(query9, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            str = data.getString(0);
        }
        return str;
    }


    // GETTER Course Name
    public String getCourseName(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_COURSE_NAME + " FROM " + TABLE_NAME + " WHERE " + COLUMN_COURSE_ID + " = '" + ID + "'";
        Cursor data = db.rawQuery(query, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            str = data.getString(0);
        }
        return str;
    }


    // GETTER Course Teacher
    public String getCourseTeacher(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_COURSE_TEACHER + " FROM " + TABLE_NAME + " WHERE " + COLUMN_COURSE_ID + " = '" + ID + "'";
        Cursor data = db.rawQuery(query, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            str = data.getString(0);
        }
        return str;
    }


    // GETTER Course Cost
    public String getCourseCost(String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_COURSE_COSTS + " FROM " + TABLE_NAME + " WHERE " + COLUMN_COURSE_ID + " = '" + ID + "'";
        Cursor data = db.rawQuery(query, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            str = data.getString(0);
        }
        return str;
    }

}
