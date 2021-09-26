package com.mymovielist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logout = findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.makeMainActivity(. this.logout. class);
            });
        }
    }

    holder.delete_btn.setOnClickListner(new View.OnClickListener()
    {
        @Override
        public void onClick (View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(holder.delete_btn.getContext());
        builder.setTitle("Are you sure?");
        builder.setMessage("Deleted data can't be undone");

        builder.setPositiveButton("Delete", DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which){
                FirebaseDatabase.getInstance().getReference().child("Students")
                        .child(getRef(position).getKey()).removeValue();
            }
                )}
        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface.dialog,int which){
                Toast.makeText(holder.name.getcontext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
    }
})

public class MainActivity1 extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView retrieveTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Most Rated Show");
        retrieveTV = findViewById(R.id.mrs_text);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Total Rated Shows");
        retrieveTV = findViewById(R.id.trs_text);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Total Watch Time");
        retrieveTV = findViewById(R.id.tws_text);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Favorite Category");
        retrieveTV = findViewById(R.id.fc_text);

        getdata();
    }
    private void getdata() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                retrieveTV.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}