package com.example.enigmassiette;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enigmassiette.data.RestaurantContract;
import com.example.enigmassiette.data.RestaurantDbHelper;

public class AddRestaurantActivity extends AppCompatActivity {

    private SQLiteDatabase myDb;
    private Button validateButton;
    private EditText name;
    private EditText date;
    private EditText time;
    private EditText decoration;
    private EditText food;
    private EditText service;
    private EditText description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        validateButton = (Button) this.findViewById(R.id.buttonValidate);
        name = (EditText) this.findViewById(R.id.name);
        date = (EditText) this.findViewById(R.id.date);
        time = (EditText) this.findViewById(R.id.time);
        decoration = (EditText) this.findViewById(R.id.decoration);
        food = (EditText) this.findViewById(R.id.food);
        service = (EditText) this.findViewById(R.id.service);
        description = (EditText) this.findViewById(R.id.description);

        RestaurantDbHelper dbHelper = new RestaurantDbHelper(this);
        myDb = dbHelper.getWritableDatabase();

        validateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String dbName = name.getText().toString();
                String dbDate = date.getText().toString();
                String dbTime = time.getText().toString();
                int dbDecoration = Integer.parseInt(decoration.getText().toString());
                int dbFood = Integer.parseInt(food.getText().toString());
                int dbService = Integer.parseInt(service.getText().toString());
                String dbDescription = description.getText().toString();

                try {
                    addNewRest(dbName, dbDate, dbTime, dbDecoration, dbFood, dbService, dbDescription);

                    Context context = AddRestaurantActivity.this;
                    Class destinationActivity = MainActivity.class;

                    Intent startAddActivityIntent = new Intent(context, destinationActivity);

                    startActivity(startAddActivityIntent);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
        });
    }

    private long addNewRest(String name, String date, String time, int decoration, int food, int service, String description) {
        ContentValues cv = new ContentValues();

        cv.put(RestaurantContract.RestaurantEntry.COLUMN_NAME, name);
        cv.put(RestaurantContract.RestaurantEntry.COLUMN_DATE, date);
        cv.put(RestaurantContract.RestaurantEntry.COLUMN_TIME, time);
        cv.put(RestaurantContract.RestaurantEntry.COLUMN_SCORE_DECORATION, decoration);
        cv.put(RestaurantContract.RestaurantEntry.COLUMN_SCORE_FOOD, food);
        cv.put(RestaurantContract.RestaurantEntry.COLUMN_SCORE_SERVICE, service);
        cv.put(RestaurantContract.RestaurantEntry.COLUMN_DESCRIPTION, description);

        return myDb.insert(RestaurantContract.RestaurantEntry.TABLE_NAME, null, cv);
    }
}
