package com.example.criccorner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
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
    RecyclerView recyclerView;
    NewsDetailsAdapter adapter;
    List<NewsDetails> itemlist = new ArrayList<>();
    Context context;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news__details_);

        context = this;
       recyclerView=findViewById(R.id.news_details_recycler_view);
        imageView=findViewById(R.id.imageview);
        textView=findViewById(R.id.news_details);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

        readFirebaseRealtimeDatabase();
    }
    public void readFirebaseRealtimeDatabase(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("news_details");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot:dataSnapshot.getChildren()){
                    NewsDetails newsDetails= singleSnapshot.getValue(NewsDetails.class);
                   itemlist.add(newsDetails);
                }
                adapter=new NewsDetailsAdapter(itemlist,context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                DatabaseError databaseError = null;
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
    }
}