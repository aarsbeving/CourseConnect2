package com.example.courseconnect2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "user_table";
    public static final String TAG = "DataBaseHelper";

    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_PASSWORD = "CUSTOMER_PSSWRD";
    public static final String COLUMN_CUSTOMER_MAIL = "CUSTOMER_EMAIL";
    public static final String COLUMN_TEACHER = "TEACHER_BOOLEAN";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable;
        createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_PASSWORD + " INT, " + COLUMN_CUSTOMER_MAIL + " TEXT, " + COLUMN_TEACHER + " TEXT)";
        db.execSQL(createTable);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    //Tests if UserName already exists
    public boolean testName(String Username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_CUSTOMER_PASSWORD + " FROM " + TABLE_NAME + " WHERE " + COLUMN_CUSTOMER_NAME + " = '" + Username + "'";
        Cursor data = db.rawQuery(query, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            return false;
        }else{
            return true;
        }
    }


    // SETTERS


    //SETTER Creates User
    public void addData(String name, String password, String mail, String teach) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CUSTOMER_NAME, name);
        contentValues.put(COLUMN_CUSTOMER_PASSWORD, password);
        contentValues.put(COLUMN_CUSTOMER_MAIL, mail);
        contentValues.put(COLUMN_TEACHER, teach);

        Log.d(TAG, "addData: Adding " + name + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + password + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + mail + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + teach + " to " + TABLE_NAME);

        db.insert(TABLE_NAME, null, contentValues);
    }


    //GETTER UserID
    public String getUserID(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_ID + " FROM " + TABLE_NAME + " WHERE " + COLUMN_CUSTOMER_NAME + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            str = data.getString(0);
        }
        return str;
    }


    //SETTER UserName
    public void setName(String UserID, String newName) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COLUMN_CUSTOMER_NAME + " = '" + newName + "' WHERE " + COLUMN_ID + " = '" + UserID + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }


    //SETTER UserPassword
    public void setPassword(String UserID, String newPw) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query2 = "UPDATE " + TABLE_NAME + " SET " + COLUMN_CUSTOMER_PASSWORD + " = '" + newPw + "' WHERE " + COLUMN_ID + " = '" + UserID + "'";
        Log.d(TAG, "updatePassword: query2: " + query2);
        Log.d(TAG, "updatePassword: Setting password to " + newPw);
        db.execSQL(query2);
    }


    //SETTER UserMail
    public void setEmail(String UserID, String newEm) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query3 = "UPDATE " + TABLE_NAME + " SET " + COLUMN_CUSTOMER_MAIL + " = '" + newEm + "' WHERE " + COLUMN_ID + " = '" + UserID + "'";
        Log.d(TAG, "updateEmail: query3: " + query3);
        Log.d(TAG, "updateEmail: Setting Email to " + newEm);
        db.execSQL(query3);
    }


    //GETTERS


    //GETTER Password
    public String getPassword(String Username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_CUSTOMER_PASSWORD + " FROM " + TABLE_NAME + " WHERE " + COLUMN_CUSTOMER_NAME + " = '" + Username + "'";
        Cursor data = db.rawQuery(query, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            str = data.getString(0);
        }
        return str;
    }


    //GETTER Teacher (boolean)
    public String getTeacher(String Username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLUMN_TEACHER + " FROM " + TABLE_NAME + " WHERE " + COLUMN_CUSTOMER_NAME + " = '" + Username + "'";
        Cursor data = db.rawQuery(query, null);
        String str = "Failed";
        if (data.moveToFirst()) {
            str = data.getString(0);
        }
        return str;
    }

}
