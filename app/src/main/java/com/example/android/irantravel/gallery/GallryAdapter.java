package com.example.android.irantravel.gallery;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by farhad-mbp on 3/21/18.
 */

public class GallryAdapter extends FragmentPagerAdapter {
    ArrayList<String> urls = new ArrayList<>();

    public GallryAdapter(FragmentManager fm, ArrayList<String> urls) {
        super(fm);
        this.urls = urls;

    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(urls.get(position));
    }

    @Override
    public int getCount() {
        return urls.size();
    }
}
