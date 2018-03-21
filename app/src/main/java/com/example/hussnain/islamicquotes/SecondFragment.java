package com.example.hussnain.islamicquotes;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    private String dayinfo;
    private String randominfo;
    private String previousinfo;
    public static SecondFragment newInstance(String dayinfo,String randominfo,String previousinfo){
        Bundle bundle=new Bundle();
        SecondFragment secondFragment=new SecondFragment();
        secondFragment.dayinfo=dayinfo;
        secondFragment.randominfo=randominfo;
        secondFragment.previousinfo=previousinfo;
        secondFragment.setArguments(bundle);
        return secondFragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View  view=inflater.inflate(R.layout.activity_second_fragment,container,false);
        TextView dayf=view.findViewById(R.id.day);
        TextView randomf=view.findViewById(R.id.random);
        TextView previous=view.findViewById(R.id.previous);
        dayf.setText(dayinfo);
        randomf.setText(randominfo);
        previous.setText(previousinfo);
        return view;
    }
}
