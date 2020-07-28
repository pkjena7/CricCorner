package com.example.criccorner;

import android.content.Context;
import android.graphics.ColorSpace;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class TeamTestFragment extends Fragment {
    Context context;
    RecyclerView recyclerView;
    TeamTestAdapter adapter;
    FirebaseFirestore firebaseFirestore;
    List<Model> itemlist = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_test, container, false);

        context = getActivity();

        recyclerView = view.findViewById(R.id.team_test_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        readFirebaseRealtimeDatabase();

        return view;
    }
    public List<Model> addDataToList() {
//        itemlist.add(new Home(R.drawable.th, "i am first image"));
//        itemlist.add(new Home(R.drawable.th, "i am first image"));
//        itemlist.add(new Home(R.drawable.th, "i am first image"));
//        itemlist.add(new Home(R.drawable.th, "i am first image"));
//        itemlist.add(new Home(R.drawable.th, "i am first image"));
//        itemlist.add(new Home(R.drawable.th, "i am first image"));
//        itemlist.add(new Home(R.drawable.th, "i am first image"));
        return itemlist;

    }

    public void readFirebaseRealtimeDatabase() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("ranking");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Model> modelList = new ArrayList<>();

                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    Model home = singleSnapshot.getValue(Model.class);
                    modelList.add(home);

                   // Log.d("onDataChange_", "onDataChange: text: " + home.getTitle() + " url: " + home.getUrl());
                }

                adapter = new TeamTestAdapter(modelList, getActivity());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

    }
}