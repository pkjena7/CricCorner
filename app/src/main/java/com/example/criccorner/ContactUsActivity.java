package com.example.criccorner;

import androidx.appcompat.app.AppCompatActivity;

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

public class ContactUsActivity extends AppCompatActivity {

    TextView textView1, textView2, textView3;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        getSupportActionBar().setTitle("Contact us");
        textView1 = findViewById(R.id.email_id);
        textView2 = findViewById(R.id.phone_no);
        textView3 = findViewById(R.id.address);
        pb = findViewById(R.id.pb);

        readFirebaseRealtimeDatabase();

    }

    public void readFirebaseRealtimeDatabase() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("contact_us");
        pb.setVisibility(View.VISIBLE);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    String email_id = singleSnapshot.child("email_id").getValue(String.class);
                    textView1.setText(email_id);
                    String phone_no = singleSnapshot.child("phone_no").getValue(String.class);
                    textView2.setText(phone_no);
                    String address = singleSnapshot.child("address").getValue(String.class);
                    textView3.setText(address);

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