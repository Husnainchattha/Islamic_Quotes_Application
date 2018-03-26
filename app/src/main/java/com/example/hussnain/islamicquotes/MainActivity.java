package com.example.hussnain.islamicquotes;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
private ViewPager viewPager;
private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.vpager);
        tabLayout=findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
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
                    return SecondFragment.newInstance("Day Ayat","Random Ayat","Previous");

                case 1:
                    return SecondFragment.newInstance("Day_Hadith","Random_Hadith","Previous_Hadith");

                case 2:
                    return SecondFragment.newInstance("Day","Random","Previous");

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

