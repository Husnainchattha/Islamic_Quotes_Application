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

public class RandomHadithFragment extends Fragment {
    private String randomHadith;
    public static RandomHadithFragment newInstance(String random){
        RandomHadithFragment fragment=new RandomHadithFragment();
        fragment.randomHadith=random;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.random_hadith_fragment,container,false);
        TextView textView=view.findViewById(R.id.randomHadith);
        textView.setText(randomHadith);
        return view;
    }
}
