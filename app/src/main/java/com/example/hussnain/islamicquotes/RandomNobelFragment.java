package com.example.hussnain.islamicquotes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hussnain.islamicquotes.AyatPakage.ApiHandler;
import com.example.hussnain.islamicquotes.AyatPakage.Preferences;
import com.example.hussnain.islamicquotes.Database.DatabaseeHelper;
import com.example.hussnain.islamicquotes.NobelPakage.NobelQuot;
import com.example.hussnain.islamicquotes.NobelPakage.RandomQuote;

/**
 * Created by hussnain on 3/28/18.
 */

public class RandomNobelFragment extends Fragment {
    public static RandomNobelFragment newInstance(){
        RandomNobelFragment fragment=new RandomNobelFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.random_nobel_fragment,container,false);
        final TextView quot=view.findViewById(R.id.randomquote);
        final TextView writername=view.findViewById(R.id.randomquotewrtr);
        final ProgressBar progressBar=view.findViewById(R.id.nprograss);
        ApiHandler.getInstance().getRandomQuote(new ApiHandler.MyCallback2(){
            @Override
            public void onSuccess(RandomQuote randomQuote) {
                quot.setVisibility(View.VISIBLE);
                writername.setVisibility(View.VISIBLE);
                quot.setText(randomQuote.getQuote());
                progressBar.setVisibility(View.GONE);
                writername.setText(randomQuote.getAuthor());
            }

            @Override
            public void onError(String message) {
                progressBar.setVisibility(View.GONE);
            }
        });
        return view;
    }
}
