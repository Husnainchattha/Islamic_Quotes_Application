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
    private static String hadith;
    public static TodayHadithFragment newInstance(String hadit){
        TodayHadithFragment fragment=new TodayHadithFragment();
        fragment.hadith=hadit;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.today_hadith_fragment,container,false);
        TextView tv=view.findViewById(R.id.hadithd);
        tv.setText(hadith);
        return view;
    }
}
