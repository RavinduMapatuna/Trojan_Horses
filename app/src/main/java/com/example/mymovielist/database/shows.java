package com.example.trojanhorses.database;

import android.provider.BaseColumns;

public class shows {
    private shows(){}

    public static class tvshows implements BaseColumns{
        public static final String TABLE_NAME = "tvshows";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DIRECTOR = "director";
        public static final String COLUMN_NAME_RELEASE = "release";
        public static final String COLUMN_NAME_DURATION = "duration";

    }
}
