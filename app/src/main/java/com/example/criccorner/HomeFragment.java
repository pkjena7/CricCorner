package com.example.criccorner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class HomeFragment extends Fragment {

    Context context;
    Fragment fragment;
    RecyclerView recyclerView;
    HomeAdapter adapter;
 //   FirebaseFirestore firebaseFirestore;
//    List<Home> itemlist = new ArrayList<>();
    ProgressBar pb;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        context = getActivity();
        fragment = this;

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("CricCorner");


        recyclerView = view.findViewById(R.id.home_recycler);
        pb = view.findViewById(R.id.pb);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        addDataToList();


        readFirebaseRealtimeDatabase();

//        adapter = new HomeAdapter(itemlist);
//        recyclerView.setAdapter(adapter);

//        firebaseFirestore = FirebaseFirestore.getInstance();

        return view;
    }


    public void readFirebaseRealtimeDatabase() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("news");
        pb.setVisibility(View.VISIBLE);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Home> homeList = new ArrayList<>();

                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    Home home = singleSnapshot.getValue(Home.class);
                    homeList.add(home);

                    Log.d("onDataChange_", "onDataChange: text: " + home.getTitle() + " url: " + home.getUrl());
                }

                adapter = new HomeAdapter(homeList, getActivity(), fragment);
                recyclerView.setAdapter(adapter);
                pb.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });


    }

    public void itemClick(int position){
       Intent intent = new Intent(context,News_Details_Activity.class);
       intent.putExtra("position",position);
       startActivity(intent);
    }

}