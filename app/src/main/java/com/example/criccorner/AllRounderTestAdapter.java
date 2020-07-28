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

public class AllRounderTestAdapter extends RecyclerView.Adapter<AllRounderTestAdapter.ViewHolder> {
    List<TestAllRounder> itemlist1;
    Context context;

    public AllRounderTestAdapter(List<TestAllRounder> itemlist1, Context context) {
        this.itemlist1 = itemlist1;
        this.context = context;
    }

    @NonNull
    @Override
    public AllRounderTestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.allrounder_test_item, parent, false);
        AllRounderTestAdapter.ViewHolder viewHolder = new AllRounderTestAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllRounderTestAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(itemlist1.get(position).getUrl())
                .into(holder.imageView);

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
