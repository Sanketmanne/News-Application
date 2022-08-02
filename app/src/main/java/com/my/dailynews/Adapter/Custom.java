package com.my.dailynews.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.my.dailynews.R;

public class Custom extends RecyclerView.ViewHolder {
    TextView textView,textView1,textView2,textView3;
    ImageView imageView;
    CardView cardView;
    public Custom(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.titleNews);
        textView1=itemView.findViewById(R.id.nameNews);
        imageView=itemView.findViewById(R.id.imageView);
        cardView=itemView.findViewById(R.id.card);
        textView2=itemView.findViewById(R.id.description);
        textView3=itemView.findViewById(R.id.time);



    }
}
