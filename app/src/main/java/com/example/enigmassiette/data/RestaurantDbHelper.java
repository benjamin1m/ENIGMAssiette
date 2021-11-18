package com.example.enigmassiette.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.enigmassiette.data.RestaurantContract.*;

public class RestaurantDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "restaurant.db";

    private static final int DATABASE_VERSION = 1;

    public RestaurantDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_RESTAURANT_TABLE = "CREATE TABLE " + RestaurantEntry.TABLE_NAME + " (" +
                RestaurantEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RestaurantEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                RestaurantEntry.COLUMN_DATE + " TEXT NOT NULL, " +
                RestaurantEntry.COLUMN_TIME + " TEXT NOT NULL, " +
                RestaurantEntry.COLUMN_SCORE_DECORATION + " INTEGER NOT NULL," +
                RestaurantEntry.COLUMN_SCORE_FOOD + " INTEGER NOT NULL, " +
                RestaurantEntry.COLUMN_SCORE_SERVICE + " INTEGER NOT NULL," +
                RestaurantEntry.COLUMN_DESCRIPTION + " TEXT" +
                ") ";

        db.execSQL(SQL_CREATE_RESTAURANT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + RestaurantEntry.TABLE_NAME);
        onCreate(db);
    }
}
