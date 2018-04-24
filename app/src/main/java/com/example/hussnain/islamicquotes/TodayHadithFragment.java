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

public class TodayHadithFragment extends Fragment {
    public static TodayHadithFragment newInstance(){
        TodayHadithFragment fragment=new TodayHadithFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.today_hadith_fragment,container,false);
        return view;
    }
}
