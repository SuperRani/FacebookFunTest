package com.example.facebookfuntest;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolder extends RecyclerView.ViewHolder {
    private View mView;
    public TextView mTitle;
    public TextView mPastTime;
    public TextView mContents;
    public ImageView mMainIng;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView = itemView;

    }

    public void setDetails(Context context, String title, String pastTime, String contents, String mainImg){
        this.mTitle = mView.findViewById(R.id.title);
        this.mPastTime = mView.findViewById(R.id.pastTime);
        this.mContents = mView.findViewById(R.id.contents);
        this.mMainIng = mView.findViewById(R.id.mainImg);

        mTitle.setText(title);
        mPastTime.setText(pastTime);
        mContents.setText(contents);
        Glide.with(context).load(mainImg).into(mMainIng);

    }
}
