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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.List;

public class AllRounderOdiAdapter extends RecyclerView.Adapter<AllRounderOdiAdapter.ViewHolder> {
    List<OdiAllRounder> itemlist1;
    Context context;

    public AllRounderOdiAdapter(List<OdiAllRounder> itemlist1, Context context) {
        this.itemlist1 = itemlist1;
        this.context = context;
    }

    @NonNull
    @Override
    public AllRounderOdiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allrounder_odi_item, parent, false);
        AllRounderOdiAdapter.ViewHolder viewHolder = new AllRounderOdiAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllRounderOdiAdapter.ViewHolder holder, int position) {



//        StorageReference ref = FirebaseStorage.getInstance().getReferenceFromUrl(itemlist1.get(position).getUrl());
//
//        Glide.with(context)
//                .load(ref)
//                .into(holder.imageView);

        holder.textView1.setText(itemlist1.get(position).getRank());
        holder.textView2.setText(itemlist1.get(position).getPlayer());
        holder.textView3.setText(itemlist1.get(position).getRating());
        holder.textView4.setText(itemlist1.get(position).getCountry());
    }

    @Override
    public int getItemCount() {
        return itemlist1.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1,textView2,textView3,textView4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView1 = itemView.findViewById(R.id.ranking);
            textView2 = itemView.findViewById(R.id.player_name);
            textView3 = itemView.findViewById(R.id.ratings);
            textView4 = itemView.findViewById(R.id.country);

        }
    }
}
