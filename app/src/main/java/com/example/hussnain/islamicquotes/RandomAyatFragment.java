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

public class RandomAyatFragment extends Fragment {
    private String randomayat;
    public static RandomAyatFragment newInstance(String randomayat){
        RandomAyatFragment fragment=new RandomAyatFragment();
        fragment.randomayat=randomayat;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.random_ayat_fragment,container,false);
        TextView textView=view.findViewById(R.id.ayatrandom);
        textView.setText(randomayat);
        return view;
    }
}
