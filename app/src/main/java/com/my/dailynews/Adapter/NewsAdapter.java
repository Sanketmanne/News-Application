package com.my.dailynews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.my.dailynews.Model.NewsApi;
import com.my.dailynews.Model.NewsHeadlines;
import com.my.dailynews.R;
import com.my.dailynews.SecondActivity2;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<Custom> {
Context context;
List<NewsHeadlines> headlines;

    public NewsAdapter(Context context, List<NewsHeadlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public Custom onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Custom(LayoutInflater.from(context).inflate(R.layout.smaple,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Custom holder, int position) {

        NewsHeadlines hedlines=headlines.get(position);

        holder.textView.setText(headlines.get(position).getTitle());
        holder.textView1.setText(headlines.get(position).getSource().getName());
        holder.textView2.setText(headlines.get(position).getDescription());
        holder.textView3.setText(headlines.get(position).getPublishedAt());

        if (headlines.get(position).getUrlToImage()!=null)
        {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.imageView);

        }
      holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(context, SecondActivity2.class);
               intent.putExtra("s1",hedlines.getAuthor());
               intent.putExtra("s2",hedlines.getContent());
               intent.putExtra("s3",hedlines.getUrlToImage());

               context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
