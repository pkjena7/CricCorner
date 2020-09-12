package com.example.criccorner;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MoreFragment extends Fragment {

    Context context;
    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4,linearLayout5,linearLayout6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        context = getActivity();
        linearLayout1=view.findViewById(R.id.more1);
        linearLayout2=view.findViewById(R.id.more2);
        linearLayout3=view.findViewById(R.id.more3);
        linearLayout4=view.findViewById(R.id.more4);
        linearLayout5=view.findViewById(R.id.more5);
        linearLayout6=view.findViewById(R.id.more6);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("More");


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,AboutUsActivity.class);
                startActivity(intent);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,FeedbackActivity.class);
                startActivity(intent);
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,RateTheAppActivity.class);
                startActivity(intent);
            }
        });
        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ContactUsActivity.class);
                startActivity(intent);
            }
        });
        linearLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });
        linearLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ShareActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}