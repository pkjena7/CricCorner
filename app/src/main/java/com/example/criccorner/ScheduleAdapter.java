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
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    List<Schedule> itemlist1;
    Context context;

    public ScheduleAdapter(List<Schedule> scheduleList, Context context) {
        this.itemlist1 = scheduleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context)
                .load(itemlist1.get(position).getUrl1())
                .into(holder.imageView1);
        Glide.with(context)
                .load(itemlist1.get(position).getUrl2())
                .into(holder.imageView2);

        holder.textView1.setText(itemlist1.get(position).getTeam1());
        holder.textView2.setText(itemlist1.get(position).getTeam2());
        holder.textView3.setText(itemlist1.get(position).getDate());
        holder.textView4.setText(itemlist1.get(position).getTime());
        holder.textView5.setText(itemlist1.get(position).getLocation());
        holder.textView6.setText(itemlist1.get(position).getDay());
        holder.textView7.setText(itemlist1.get(position).getMatch_no());
    }

    @Override
    public int getItemCount() {
        return itemlist1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1,imageView2;
        TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.team1_image);
            imageView2 = itemView.findViewById(R.id.team2_image);
            textView1 = itemView.findViewById(R.id.team1);
            textView2 = itemView.findViewById(R.id.team2);
            textView3 = itemView.findViewById(R.id.date);
            textView4 = itemView.findViewById(R.id.time);
            textView5 = itemView.findViewById(R.id.location);
            textView6 = itemView.findViewById(R.id.day);
            textView7 = itemView.findViewById(R.id.match_no);

        }
    }


}
