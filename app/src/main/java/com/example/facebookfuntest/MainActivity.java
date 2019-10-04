package com.example.facebookfuntest;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.content.Context;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    public ViewPager mVp;
    public ContentsPagerAdapter mContentsPagerAdapter;
    public TabLayout mTabLayout;
    public Context mContext;


    /**
     * 1. glide cache
     * 2. storage permission (runtime permission)
     * 3. tab content -> fragment
     * <p>
     * next
     * AsyncTask --> network --> HttpUrlConnection (background thread)
     * Kotlin
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.newspeed)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.group)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.watch)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.mine)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.alert)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mVp = (ViewPager) findViewById(R.id.vp);

        mContentsPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mVp.setAdapter(mContentsPagerAdapter);

        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {  //탭 선택되었을 때 호출
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {    // 탭이 선택되지 않았을 대 호출

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {    // 탭이 다시 선택되었을 때 호출

            }
        });


    }


    private View createTabView(int tabIcon) {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);

        ImageView img_name = (ImageView) tabView.findViewById(R.id.img);

        img_name.setBackgroundResource(tabIcon);

        return tabView;

    }
}

