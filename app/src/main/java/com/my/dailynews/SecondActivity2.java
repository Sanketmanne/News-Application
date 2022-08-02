package com.my.dailynews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity2 extends AppCompatActivity {
   TextView author1,contextt;
   ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        author1=findViewById(R.id.author);
        contextt=findViewById(R.id.contexct);
        imageView=findViewById(R.id.imageView2);

       String author=getIntent().getStringExtra("s1");
       String con=getIntent().getStringExtra("s2");
       String thumb=getIntent().getStringExtra("s3");

       author1.setText(author);
       contextt.setText(con);
        Picasso.get().load(thumb).into(imageView);

    }
}