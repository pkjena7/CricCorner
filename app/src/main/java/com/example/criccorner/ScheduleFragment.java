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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class ScheduleFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    ScheduleAdapter adapter;
    FirebaseFirestore firebaseFirestore;
    List<Schedule> itemlist = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        context = getActivity();

        recyclerView = view.findViewById(R.id.schedule_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

//        addDataToList();


        readFirebaseRealtimeDatabase();

//        adapter = new HomeAdapter(itemlist);
//        recyclerView.setAdapter(adapter);

        firebaseFirestore = FirebaseFirestore.getInstance();

        return view;
    }

    public List<Schedule> addDataToList() {
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

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("matches");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<Schedule> scheduleList = new ArrayList<>();

                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    Schedule schedule = singleSnapshot.getValue(Schedule.class);
                    scheduleList.add(schedule);

                   // Log.d("onDataChange_", "onDataChange: text: " + schedule.getTeam1() + " url: " + schedule.getUrl1());
                }

                adapter = new ScheduleAdapter(scheduleList, getActivity());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAG, "onCancelled", databaseError.toException());
            }
        });

    }
}