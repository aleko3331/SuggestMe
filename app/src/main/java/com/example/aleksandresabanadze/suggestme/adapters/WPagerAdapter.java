package com.example.aleksandresabanadze.suggestme.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.aleksandresabanadze.suggestme.ui.FragGeneration;
import com.example.aleksandresabanadze.suggestme.ui.FragWishes;


public class WPagerAdapter extends FragmentPagerAdapter {

    private static int TOTAL_ITEMS = 2;

    public WPagerAdapter(FragmentManager fm) { super(fm); }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return FragGeneration.newInstance();
            case 1:
                return FragWishes.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TOTAL_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Generate";
            case 1:
                return "Wished";
            default:
                return "";
        }
    }

}
