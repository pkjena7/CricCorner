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

public class TeamOdiAdapter extends RecyclerView.Adapter<TeamOdiAdapter.ViewHolder> {
    List<OdiTeam> itemlist1;
    Context context;

    public TeamOdiAdapter(List<OdiTeam> itemlist1, Context context) {
        this.itemlist1 = itemlist1;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamOdiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_odi_item, parent, false);
        TeamOdiAdapter.ViewHolder viewHolder = new TeamOdiAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamOdiAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(itemlist1.get(position).getUrl())
                .into(holder.imageView);

        holder.textView1.setText(itemlist1.get(position).getRank());
        holder.textView2.setText(itemlist1.get(position).getTeam());
        holder.textView3.setText(itemlist1.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return itemlist1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1, textView2, textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);
            textView1 = itemView.findViewById(R.id.ranking);
            textView2 = itemView.findViewById(R.id.team_name);
            textView3 = itemView.findViewById(R.id.ratings);

        }
    }
}
