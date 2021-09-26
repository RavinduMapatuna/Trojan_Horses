package com.example.trojanhorses;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trojanhorses.database.DBHelper;

public class Addshow extends AppCompatActivity {

    EditText txtTitle,txtDirector,txtDate,txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addshow);

        txtTitle = findViewById(R.id.txtTitle1);
        txtDirector = findViewById(R.id.txtDirector1);
        txtDate = findViewById(R.id.txtDate1);
        txtTime = findViewById(R.id.txtTime1);
    }
    //navigation
    public void AddNewShow(View view){
//
//        Intent intent = new Intent(this,Mytvshows.class);
//
        String Title = txtTitle.getText().toString();
        String Director = txtDirector.getText().toString();
        String Release = txtDate.getText().toString();
        String Duration = txtTime.getText().toString();

        DBHelper dbHelper = new DBHelper(this);

        if(Title.isEmpty()||Director.isEmpty()){

            Toast.makeText(this,"Enter values",Toast.LENGTH_SHORT).show();
        }else {
          long inserted = dbHelper.addShow(Title,Director,Release,Duration);
        }
    }
//
//        intent.putExtra("title",Title);
//        intent.putExtra("director",Director);
//        intent.putExtra("date",Date);
//        intent.putExtra("time",Time);
//
//        startActivity(intent);
//
//
//    }
}