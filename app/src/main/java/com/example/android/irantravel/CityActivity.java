package com.example.android.irantravel;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.android.irantravel.Classes.Places;
import com.example.android.irantravel.Fragments.FoodFragment;
import com.example.android.irantravel.Fragments.InfoFragment;
import com.example.android.irantravel.Fragments.ShopFragment;
import com.example.android.irantravel.Fragments.SightsFragment;
import com.example.android.irantravel.R;

public class CityActivity extends AppCompatActivity {
    public static final String ARG_CIT = "city";
    public static String CITY_NAME = null;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        Intent i = getIntent();
        CITY_NAME = i.getStringExtra(ARG_CIT);
        Bundle bundle = new Bundle();
        bundle.putString("ARG_CIT", CITY_NAME);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_city);
        toolbar.setTitle(""+CITY_NAME);




        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_city, menu);
        return true;
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_city, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    SightsFragment sightsFragment = new SightsFragment();
                    Bundle sbundle = new Bundle();
                    sbundle.putString("ARG_CIT", CITY_NAME);
                    sightsFragment.setArguments(sbundle);
                    return sightsFragment;
                case 1:
                    FoodFragment foodFragment = new FoodFragment();
                    Bundle fbundle = new Bundle();
                    fbundle.putString("ARG_CIT", CITY_NAME);
                    foodFragment.setArguments(fbundle);
                    return foodFragment;
                case 2:
                    ShopFragment shopFragment = new ShopFragment();
                    Bundle shbundle = new Bundle();
                    shbundle.putString("ARG_CIT", CITY_NAME);
                    shopFragment.setArguments(shbundle);
                    return shopFragment;
                case 3:
                    InfoFragment infoFragment = new InfoFragment();
                    Bundle ibundle = new Bundle();
                    ibundle.putString("ARG_CIT", CITY_NAME);
                    infoFragment.setArguments(ibundle);
                    return infoFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SIGHTS";
                case 1:
                    return "FOOD";
                case 2:
                    return "SHOPS";
                case 3:
                    return  "INFO";
            }
            return null;
        }


    }
}
