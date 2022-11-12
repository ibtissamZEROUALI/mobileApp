package com.example.cloudbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;

    //we declare some constant
    private static final String DATABASE_NAME = "CloudBank.db";
    private static final int DATABASE_VERSION = 1;


    private static final String TABLE_NAME = "Transactions";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TYPE = "transaction_type";
    private static final String COLUMN_MONEY = "MONEY";
    private static final String COLUMN_DATE = "date_transaction";
    private static final String COLUMN_IMAGE = "image";


    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context =context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TYPE + " TEXT, " +
                COLUMN_MONEY + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_IMAGE + " TEXT);";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    Cursor selectTransaction() {
        String query= "SELECT * FROM " + TABLE_NAME + ";";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor=null;
        //verifying if the db have data
        if (db != null){
            cursor = db.rawQuery(query,null);

        }

        return cursor;
    }

    //this if we want to add transaction we can add a new activity to do soo
    void insertTransaction(String typeTransaction, String money, String date, String image_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TYPE, typeTransaction);
        cv.put(COLUMN_MONEY, money);
        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_IMAGE, image_id);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully", Toast.LENGTH_SHORT).show();

        }

    }

}
