package com.example.enigmassiette;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.enigmassiette.data.RestaurantContract;
import com.example.enigmassiette.data.RestaurantDbHelper;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.enigmassiette.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RestaurantListAdapter myAdapter;
    private SQLiteDatabase myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        RecyclerView restaurantsRecyclerView;

        restaurantsRecyclerView = (RecyclerView) this.findViewById(R.id.all_restaurant);

        restaurantsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        RestaurantDbHelper dbHelper = new RestaurantDbHelper(this);

        myDb = dbHelper.getWritableDatabase();

        System.out.println(getAllRestaurants());

        Cursor cursor = getAllRestaurants();
        System.out.println(cursor);

        myAdapter = new RestaurantListAdapter(this, cursor.getCount());

        restaurantsRecyclerView.setAdapter(myAdapter);


        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = MainActivity.this;
                Class destinationActivity = AddRestaurantActivity.class;

                Intent startAddActivityIntent = new Intent(context, destinationActivity);

                startActivity(startAddActivityIntent);
            }
        });
    }

    private Cursor getAllRestaurants() {
        return myDb.query(RestaurantContract.RestaurantEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}