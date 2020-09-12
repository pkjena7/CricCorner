package com.example.criccorner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class News_Details_Activity extends AppCompatActivity {
    List<NewsDetails> itemlist = new ArrayList<>();
    Context context;
    ImageView imageView;
    TextView textView;
    int position = 0;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__details_);
        getSupportActionBar().setTitle("CricCorner");

        context = this;

        if (getIntent() != null) {
            position = getIntent().getIntExtra("position", 0);
        }

        imageView = findViewById(R.id.imageview);
        textView = findViewById(R.id.news_details);
        pb = findViewById(R.id.pb);

        readFirebaseRealtimeDatabase();
    }

    public void readFirebaseRealtimeDatabase() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("news_details");
        pb.setVisibility(View.VISIBLE);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    NewsDetails newsDetails = singleSnapshot.getValue(NewsDetails.class);
                    itemlist.add(newsDetails);
                }

                if (position < itemlist.size()) {

                    NewsDetails newsModel = itemlist.get(position);

                    Glide.with(context)
                            .load(newsModel.getUrl())
                            .into(imageView);

                    textView.setText(newsModel.getNews());

                }
                pb.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                DatabaseError databaseError = null;
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
    }
}