package com.example.criccorner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MatchDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Context context;
    int position =0;
    List<MatchDetailsList> itemlist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        getSupportActionBar().setTitle("CricCorner");

        imageView=findViewById(R.id.imageview);
        textView=findViewById(R.id.match_details);
        context=this;
        if (getIntent()!=null){
            position=   getIntent().getIntExtra("position",0);
        }

        readFirebaseRealtimeDatabase();
    }
    public void readFirebaseRealtimeDatabase(){
        DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("match_details");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot:dataSnapshot.getChildren()){
                    MatchDetailsList matchDetailsList= singleSnapshot.getValue(MatchDetailsList.class);
                    itemlist.add(matchDetailsList);
                }

                if (position<itemlist.size()){

                    MatchDetailsList matchDetailsList = itemlist.get(position);

                    Glide.with(context)
                            .load(matchDetailsList.getUrl())
                            .into(imageView);

                    textView.setText(matchDetailsList.getMatch_details());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                DatabaseError databaseError = null;
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });
    }
}