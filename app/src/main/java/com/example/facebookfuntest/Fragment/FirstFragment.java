package com.example.facebookfuntest.Fragment;


import android.app.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebookfuntest.ItemClass;
import com.example.facebookfuntest.R;
import com.example.facebookfuntest.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirstFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FirebaseDatabase mFirebaseDatabase;
    public DatabaseReference mRef;
    private Activity activity;


    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.fragment_first, null);
        mRecyclerView = rootView.findViewById(R.id.recyclerviewTab1);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FirebaseRecyclerAdapter<ItemClass, ViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<ItemClass, ViewHolder>(ItemClass.class, R.layout.item, ViewHolder.class, mRef) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, ItemClass itemClass, int i) {
                viewHolder.setDetails(activity.getApplicationContext(), itemClass.getTitle(), itemClass.getPastTime(), itemClass.getContents(), itemClass.getMainImg());

            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
