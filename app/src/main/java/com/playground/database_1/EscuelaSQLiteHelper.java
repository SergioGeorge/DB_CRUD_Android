package com.playground.database_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class EscuelaSQLiteHelper extends SQLiteOpenHelper {
    private static final String LOG_INFO = "EscuelaSQLiteHelper";
    private static final String DATABASE_NAME = "school.db";
    private static final String TABLE_NAME = "student";
    private static final String COL_1 = "id";
    private static final String COL_2 = "name";
    private static final String COL_3 = "age";
    private static final String COL_4 = "grupo";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, grupo TEXT)";

    private ArrayList<StudentPOJO> arrayStudent;

    public  EscuelaSQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    public boolean registrarAlumno(String name, String age, String grupo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, age);
        contentValues.put(COL_4, grupo);

        long result = db.insert(TABLE_NAME, null, contentValues);

        Log.i(LOG_INFO, "Id returned from Table " + result);

        if(result == -1)
            return false;
        else
            return true;
    }

    public ArrayList<StudentPOJO> consultarAlumnos() {
        SQLiteDatabase db = this.getWritableDatabase();
        arrayStudent = new ArrayList<>();
        Cursor result = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(result.getCount() < 0)
            return null;
        else
        {
            while (result.moveToNext()) {
                arrayStudent.add(new StudentPOJO(result.getString(1), result.getString(2), result.getString(3)));
            }
        }
        return arrayStudent;
    }
}
