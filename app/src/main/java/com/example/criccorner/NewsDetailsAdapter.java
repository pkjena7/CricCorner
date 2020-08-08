package com.example.criccorner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class NewsDetailsAdapter extends RecyclerView.Adapter<NewsDetailsAdapter.ViewHolder> {

    List<NewsDetails> itemlist1;
    Context context;

    public NewsDetailsAdapter(List<NewsDetails> itemlist, Context context) {
        this.itemlist1 = itemlist;
        this.context = context;
    }


    @NonNull
    @Override
    public NewsDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_details_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsDetailsAdapter.ViewHolder holder, int position) {

        Glide.with(context)
                .load(itemlist1.get(position).getUrl())
                .into(holder.imageView);

        holder.textView.setText(itemlist1.get(position).getNews());

    }

    @Override
    public int getItemCount() {
        return itemlist1.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.news_details);

        }
    }
}
