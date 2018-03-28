package com.example.hussnain.islamicquotes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hussnain on 3/28/18.
 */

public class TodayNobelFragment extends Fragment {
    public static String today;
    public static TodayNobelFragment newInstance(String day){
        TodayNobelFragment fragment=new TodayNobelFragment();
        fragment.today=day;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.today_nobel_fragment,container,false);
        TextView textView=view.findViewById(R.id.nobeltoday);
        textView.setText(today);
        return  view;
    }
}
