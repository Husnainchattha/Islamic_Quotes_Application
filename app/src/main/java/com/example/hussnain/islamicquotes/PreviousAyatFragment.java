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

public class PreviousAyatFragment extends Fragment {
    private String previousayat;
    public static PreviousAyatFragment newInstance(String previouayat){
        PreviousAyatFragment fragment=new PreviousAyatFragment();
        fragment.previousayat=previouayat;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.previous_ayat_fragment,container,false);
        TextView textView=view.findViewById(R.id.previousayat);
        textView.setText(previousayat);
        return view;
    }
}
