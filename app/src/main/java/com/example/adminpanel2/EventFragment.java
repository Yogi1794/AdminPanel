package com.example.adminpanel2;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {


    public EventFragment() {

        // Required empty public constructor
    }
    List<Event> list;
    RecyclerViewAdapter1 adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_event, container, false);
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        list=new ArrayList<>();

        final RecyclerView recyclerView=view.findViewById(R.id.recyclerview1);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setLayoutManager(layoutManager);


        databaseReference.child("Users");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Event e=new Event();

                String date = dataSnapshot.child("Event Detail").child("date").getValue(String.class);
                String time = dataSnapshot.child("Event Detail").child("time").getValue(String.class);
                String eventName = dataSnapshot.child("Event Detail").child("eventName").getValue(String.class);
                String eventAddress = dataSnapshot.child("Event Detail").child("eventAddress").getValue(String.class);
                //  Toast.makeText(getActivity(), date, Toast.LENGTH_LONG).show();
                e.setDate(date);
                e.setTime(time);
                e.setEventn(eventName);
                e.setAddress(eventAddress);
                list.add(e);
                /*TextView date1 = view.findViewById(R.id.date);
                date1.setText(date);
                TextView time1 = view.findViewById(R.id.time);
                time1.setText(time);
                TextView Event = view.findViewById(R.id.eventn);
                Event.setText(eventName);
                TextView Address1 = view.findViewById(R.id.address);
                Address1.setText(eventAddress);*/


                adapter=new RecyclerViewAdapter1(getActivity(),list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

}
