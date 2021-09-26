package com.mymovielist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserProfileUpdate extends AppCompatActivity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_update);
        logout = findViewById(R.id.logout_btn);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileUpdate.this.logout. ;class)
                )
            }


    public void Update(View view) {
    }
    public class UserProfileUpdate extends AppCompatActivity {

        EditText etName, etLastName, etEmail, etPassword, etVerifyPassword;
        final int MIN_PASSWORD_LENGTH = 6;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_profile_update);

            viewInitializations();
        }
        void viewInitializations() {
            etName = findViewById(R.id.name_box);
            etEmail = findViewById(R.id.emailView);
            etPassword = findViewById(R.id.passwordView);
            etVerifyPassword = findViewById(R.id.re_passwordView);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        boolean validateInput() {
            if (etName.getText().toString().equals("")) {
                etName.setError("Please Enter Name");
                return false;
            }
            if (etEmail.getText().toString().equals("")) {
                etEmail.setError("Please Enter Email");
                return false;
            }
            if (etPassword.getText().toString().equals("")) {
                etPassword.setError("Please Enter Password");
                return false;
            }
            if (etVerifyPassword.getText().toString().equals("")) {
                etVerifyPassword.setError("Please Re-Enter Password ");
                return false;
            }

            if (!isEmailValid(etEmail.getText().toString())) {
                etEmail.setError("Please Enter Valid Email");
                return false;
            }
            return true;
        }

        boolean isEmailValid(String email) {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }
        public void performEditProfile(View v) {
            if (validateInput()) {

                String Name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String contactNo = etPassword.getText().toString();
                String Designation = etVerifyPassword.getText().toString();

                Toast.makeText(this, "Profile Update Successfully", Toast.LENGTH_SHORT).show();


            }
        }

    }

    class DeleteUser extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_profile_update);
            final EditText email = findViewById(R.id.emailView);
            final EditText password = findViewById(R.id.passwordView);
            Button submit = findViewById(R.id.delete_btn);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteuser(email.getText().toString(), password.getText().toString());
                }
            });
        }
        private void deleteuser(String email, String password) {

            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            AuthCredential credential = EmailAuthProvider.getCredential(email, password);

            if (user != null) {
                user.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                user.delete()
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Log.d("TAG", "User account deleted.");
                                                    startActivity(new Intent(DeleteUser.this, StartActivity.class));
                                                    Toast.makeText(DeleteUser.this, "Deleted User Successfully,", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                            }
                        });
            }
        }

    }

