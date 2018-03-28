package com.example.hussnain.islamicquotes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hussnain on 3/26/18.
 */

public class Ayat extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    public static Ayat newInstance() {
        Bundle bundle=new Bundle();
        Ayat fragment = new Ayat();
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ayat_layout,container,false);

        viewPager=view.findViewById(R.id.vpager);
        tabLayout=view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        PagerAdapter pagerAdapter=new PagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        return view;
    }
    private class PagerAdapter extends FragmentPagerAdapter {
        private String[]titalbar={"Today","Random","Previous"};
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return TodayAyatFragment.newInstance("Today Ayat");

                case 1:
                    return RandomAyatFragment.newInstance("Random Ayat");

                case 2:
                    return PreviousAyatFragment.newInstance("Previous ayat");

                default:
                    return null;}
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titalbar[position];
        }
    }
}
