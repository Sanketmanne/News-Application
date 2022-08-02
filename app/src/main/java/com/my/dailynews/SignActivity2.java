package com.my.dailynews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.storage.FirebaseStorage;
import com.my.dailynews.Model.Users;
import com.my.dailynews.databinding.ActivitySign2Binding;

public class SignActivity2 extends AppCompatActivity {
ActivitySign2Binding binding;
FirebaseDatabase database;
FirebaseAuth auth;
FirebaseUser currentUser;
//FirebaseStorage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySign2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();
        currentUser=auth.getCurrentUser();
       // storage=FirebaseStorage.getInstance();

        binding.signupE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=binding.emailED.getText().toString(),password=binding.PasswordED.getText().toString();
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Users signModel=new Users(binding.nameEt.getText().toString(),binding.professionED.getText().toString(),email,password);
                            String id=task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(signModel);

                            Toast.makeText(SignActivity2.this, "User Successfully Register...", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(SignActivity2.this,MainActivity.class);
                            startActivity(intent);

                        }
                        else
                        {
                            Toast.makeText(SignActivity2.this, "User Not Register", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        binding.goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignActivity2.this,sign_inActivity.class);
                startActivity(intent);
            }
        });





    }

    @Override
    protected void onStart() {
        if (currentUser!=null)
        {
            Intent intent=new Intent(SignActivity2.this,MainActivity.class);
            startActivity(intent);
        }
        super.onStart();
    }
}