package com.my.dailynews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.my.dailynews.Model.Users;
import com.my.dailynews.databinding.ActivitySignInBinding;

public class sign_inActivity extends AppCompatActivity {

    ActivitySignInBinding binding;
    FirebaseDatabase database;
    FirebaseAuth auth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.signinu.getText().toString();
                String password = binding.signinp.getText().toString();
                auth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(sign_inActivity.this, "Login Successful..", Toast.LENGTH_SHORT).show();
                          Intent intent=new Intent(sign_inActivity.this,SignActivity2.class);
                          startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(sign_inActivity.this, "Login Failed..", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        binding.goToSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(sign_inActivity.this,SignActivity2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        if (currentUser != null) {
            Intent intent = new Intent(sign_inActivity.this, MainActivity.class);
            startActivity(intent);
        }
        super.onStart();
    }
}