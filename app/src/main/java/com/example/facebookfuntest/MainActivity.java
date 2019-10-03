package com.example.facebookfuntest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TabHost;

import com.bumptech.glide.load.model.Model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = findViewById(R.id.tabHost);
        host.setup();
        TabHost.TabSpec spec = host.newTabSpec("Tab1");


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerviewTab1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Data");



        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.newspeed, null));
        spec.setContent(R.id.recyclerviewTab1);
        host.addTab(spec);


        spec = host.newTabSpec("tab2");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.group, null));
        spec.setContent(R.id.tab_content2);
        host.addTab(spec);

        spec = host.newTabSpec("tab3");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.watch, null));
        spec.setContent(R.id.tab_content3);
        host.addTab(spec);

        spec = host.newTabSpec("tab4");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.mine, null));
        spec.setContent(R.id.tab_content4);
        host.addTab(spec);

        spec = host.newTabSpec("tab5");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.alert, null));
        spec.setContent(R.id.tab_content5);
        host.addTab(spec);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ItemClass, ViewHolder> firebaseRecyclerAdapter
                = new FirebaseRecyclerAdapter<ItemClass, ViewHolder>(ItemClass.class, R.layout.item, ViewHolder.class, mRef) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, ItemClass itemClass, int i) {
                viewHolder.setDetails(getApplicationContext(), itemClass.getTitle(), itemClass.getPastTime(), itemClass.getContents(), itemClass.getMainImg());

            }
        };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
