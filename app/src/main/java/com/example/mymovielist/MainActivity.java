package com.example.trojanhorses;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.trojanhorses.database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtTitle,txtDirector,txtDate,txtTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = findViewById(R.id.txtTitle);
        txtDirector = findViewById(R.id.txtDirector);
        txtDate = findViewById(R.id.txtDate);
        txtTime = findViewById(R.id.txtTime);
    }

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


    public void viewAll(View view){
        DBHelper dbHelper = new DBHelper(this);
        List.info = dbHelper.readAll();

        String[] infoArray = (String[]) info.toArray(new String[0]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("tv show details");

        builder.setItems(infoArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                String title = infoArray[i].split(":")[0];
                //Toast.makeText(MainActivity.this, Toast.LENGTH_SHORT).show();

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void deleteShow(View view){
        DBHelper dbHelper = new DBHelper(this);

        String Title = txtTitle.getText().toString();
        String Director = txtDirector.getText().toString();
        String Release = txtDate.getText().toString();
        String Duration = txtTime.getText().toString();

        if(Title.isEmpty()||Director.isEmpty()||Release.isEmpty()||Duration.isEmpty()){
            Toast.makeText(this,"select title,director,release date,duration",
                    Toast.LENGTH_SHORT).show();
        }else {
            dbHelper.deleteinfo(Title);
            Toast.makeText(this,"select item deleted",Toast.LENGTH_SHORT).show();
        }
    }
}