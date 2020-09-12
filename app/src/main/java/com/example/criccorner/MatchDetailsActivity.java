package com.example.criccorner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
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

public class MatchDetailsActivity extends AppCompatActivity {

    ImageView imageView, imageView2;
    TextView textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11;
    Context context;
    int position = 0;
    Toolbar toolbar;
    List<MatchDetailsList> itemlist = new ArrayList<>();
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_details);
        getSupportActionBar().setTitle("Matches");
        // toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // imageView2 = findViewById(R.id.back);
//        pb = findViewById(R.id.pb);
//       pb.setVisibility(View.VISIBLE);

        imageView = findViewById(R.id.imageview);
        textView1 = findViewById(R.id.full_squad1);
        textView2 = findViewById(R.id.full_squad2);
        textView3 = findViewById(R.id.team1);
        textView4 = findViewById(R.id.team2);
        textView5 = findViewById(R.id.safe_eleven1);
        textView6 = findViewById(R.id.safe_eleven2);
        textView7 = findViewById(R.id.safe_eleven3);
        textView8 = findViewById(R.id.probable_1);
        textView9 = findViewById(R.id.probable_squad1);
        textView10 = findViewById(R.id.probable_2);
        textView11 = findViewById(R.id.probable_squad2);

        //  pb.setVisibility(View.GONE);

        context = this;

//        imageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MatchDetailsActivity.this,MainActivity.class);
//                intent.putExtra("key",1);
//                startActivity(intent);
//
//            }
//        });

        if (getIntent() != null) {
            position = getIntent().getIntExtra("position", 0);
        }

        readFirebaseRealtimeDatabase();
    }

    public void readFirebaseRealtimeDatabase() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("match_details");


        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    MatchDetailsList matchDetailsList = singleSnapshot.getValue(MatchDetailsList.class);
                    itemlist.add(matchDetailsList);
                }

                if (position < itemlist.size()) {

                    MatchDetailsList matchDetailsList = itemlist.get(position);

                    Glide.with(context)
                            .load(matchDetailsList.getUrl())
                            .into(imageView);

                    textView1.setText(matchDetailsList.getFull_squad1());
                    textView2.setText(matchDetailsList.getFull_squad2());
                    textView3.setText(matchDetailsList.getTeam1());
                    textView4.setText(matchDetailsList.getTeam2());
                    textView5.setText(matchDetailsList.getSafe_eleven1());
                    textView6.setText(matchDetailsList.getSafe_eleven2());
                    textView7.setText(matchDetailsList.getSafe_eleven3());
                    textView9.setText(matchDetailsList.getProbable_eleven1());
                    textView11.setText(matchDetailsList.getProbable_eleven2());


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