package com.example.trojanhorses.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "TvshowsInfo.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE "+shows.tvshows.TABLE_NAME+" (" +
                        shows.tvshows._ID+ " INTEGER PRIMARY KEY," +
                        shows.tvshows.COLUMN_NAME_TITLE+ " TEXT," +
                        shows.tvshows.COLUMN_NAME_DIRECTOR+ " TEXT," +
                        shows.tvshows.COLUMN_NAME_RELEASE+ " TEXT," +
                        shows.tvshows.COLUMN_NAME_DURATION+ " TEXT)";

        db.execSQL(SQL_CREATE_ENTRIES);

    }
    public long addShow(String title, String director,String release, String duration){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(shows.tvshows.COLUMN_NAME_TITLE, title);
        values.put(shows.tvshows.COLUMN_NAME_DIRECTOR, director);
        values.put(shows.tvshows.COLUMN_NAME_RELEASE,release);
        values.put(shows.tvshows.COLUMN_NAME_DURATION,duration);

        return db.insert(shows.tvshows.TABLE_NAME, null, values);
    }

    public List readAll(){
        SQLiteDatabase db = getReadableDatabase();

        String [] projection =(
                shows.tvshows._ID,
                shows.tvshows.COLUMN_NAME_TITLE,
                shows.tvshows.COLUMN_NAME_DIRECTOR,
                shows.tvshows.COLUMN_NAME_RELEASE,
                shows.tvshows.COLUMN_NAME_DURATION
        );
        String sortorder = shows.tvshows._ID+ "DESC";

        Cursor cursor = db.query(
               shows.tvshows.TABLE_NAME,
                projection,
                null,
                null,
                null,
                sortorder,);

        List info = new ArrayList<>();

        while (cursor.moveToNext()){
            String Title = cursor.getString(cursor.getColumnIndexOrThrow(shows.tvshows.COLUMN_NAME_TITLE));
            String Director = cursor.getString(cursor.getColumnIndexOrThrow(shows.tvshows.COLUMN_NAME_DIRECTOR));
            String Release = cursor.getString(cursor.getColumnIndexOrThrow(shows.tvshows.COLUMN_NAME_RELEASE));
            String Duration = cursor.getString(cursor.getColumnIndexOrThrow(shows.tvshows.COLUMN_NAME_DURATION));

            info.add(Title+":"+Director+":"+Release+":"+Duration);

        }
        cursor.close();
        return info;

    }

    public void deleteinfo(String title){
        SQLiteDatabase db = getReadableDatabase();

        String selection = shows.tvshows.COLUMN_NAME_TITLE +" LIKE ?";
        String[] stringArgs ={title};

        db.delete(shows.tvshows.TABLE_NAME,selection,stringArgs);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
