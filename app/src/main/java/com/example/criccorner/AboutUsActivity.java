package com.example.criccorner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class AboutUsActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        getSupportActionBar().setTitle("About us");

        textView = findViewById(R.id.about_us);
        pb = findViewById(R.id.pb);
        readFirebaseRealtimeDatabase();
    }

    public void readFirebaseRealtimeDatabase() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("about_us");
        pb.setVisibility(View.VISIBLE);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    String about_us = singleSnapshot.getValue(String.class);
                    textView.setText(about_us);

                    // Log.d("onDataChange_", "onDataChange: text: " + home.getTitle() + " url: " + home.getUrl());
                }
                pb.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

    }
}