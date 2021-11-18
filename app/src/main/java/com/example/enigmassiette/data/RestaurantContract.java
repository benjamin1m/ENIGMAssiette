package com.example.enigmassiette.data;

import android.provider.BaseColumns;

public class RestaurantContract {

    public static final class RestaurantEntry implements BaseColumns {

        public static final String TABLE_NAME = "restaurant";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_SCORE_DECORATION = "scoreDecoration";
        public static final String COLUMN_SCORE_FOOD = "scoreFood";
        public static final String COLUMN_SCORE_SERVICE = "scoreService";
        public static final String COLUMN_DESCRIPTION = "description";
    }

}
