package com.example.criccorner;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class BowlerTestFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    BowlerTestAdapter adapter;
    FirebaseFirestore firebaseFirestore;
    ProgressBar pb;
    List<TestBowler> itemlist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bowler_test, container, false);

        context = getActivity();

        recyclerView = view.findViewById(R.id.bowler_test_recycler);
        pb = view.findViewById(R.id.pb);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        readFirebaseRealtimeDatabase();

        return view;
    }
    public void readFirebaseRealtimeDatabase() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("test_bowler");
        pb.setVisibility(View.VISIBLE);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<TestBowler> playerList = new ArrayList<>();

                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    TestBowler home = singleSnapshot.getValue(TestBowler.class);
                    playerList.add(home);

                    // Log.d("onDataChange_", "onDataChange: text: " + home.getTitle() + " url: " + home.getUrl());
                }

                adapter = new BowlerTestAdapter(playerList, getActivity());
                recyclerView.setAdapter(adapter);
                pb.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

    }
}