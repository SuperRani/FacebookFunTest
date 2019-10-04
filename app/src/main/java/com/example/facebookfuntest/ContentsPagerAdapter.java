package com.example.facebookfuntest;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.facebookfuntest.Fragment.FifthFragment;
import com.example.facebookfuntest.Fragment.FirstFragment;
import com.example.facebookfuntest.Fragment.FourthFragment;
import com.example.facebookfuntest.Fragment.SecondFragment;
import com.example.facebookfuntest.Fragment.ThirdFragment;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter {
    private int mPageCount;


    public ContentsPagerAdapter(final FragmentManager fm, final int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {

            case 0: {
                FirstFragment firstFragment = new FirstFragment();
                return firstFragment;

            }
            case 1: {
                SecondFragment secondFragment = new SecondFragment();
                return secondFragment;
            }


            case 2: {
                ThirdFragment thirdFragment = new ThirdFragment();
                return thirdFragment;
            }


            case 3: {
                FourthFragment fourthFragment = new FourthFragment();
                return fourthFragment;
            }


            case 4: {
                FifthFragment fifthFragment = new FifthFragment();
                return fifthFragment;
            }

            default: {
                return null;
            }

        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
