package com.example.trojanhorses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Mytvshows extends AppCompatActivity {

    TextView tv_title;
    TextView tv_director;
    TextView tv_release;
    TextView tv_duration;

    String showtitle;
    String showdirector;
    String showrelease;
    String showduration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mytvshows);

        tv_title = findViewById(R.id.tv_title);
        tv_director = findViewById(R.id.tv_director);
        tv_release = findViewById(R.id.tv_release);
        tv_duration = findViewById(R.id.tv_duration);

        Intent intent= getIntent();

        showtitle = intent.getStringExtra("title");
        showdirector = intent.getStringExtra("director");
        showrelease = intent.getStringExtra("date");
        showduration = intent.getStringExtra("time");

        tv_title.setText(showtitle);
        tv_director.setText(showdirector);
        tv_release.setText(showrelease);
        tv_duration.setText(showduration);





    }
}