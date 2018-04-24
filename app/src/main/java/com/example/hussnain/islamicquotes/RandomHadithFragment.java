package com.example.hussnain.islamicquotes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bullhead.quranquotes.domain.Verse;
import com.bullhead.quranquotes.domain.hadith.Hadith;
import com.bullhead.quranquotes.views.QuranVerseView;
import com.bullhead.quranquotes.views.RandomHadithView;
import com.example.hussnain.islamicquotes.Database.DatabaseeHelper;

/**
 * Created by hussnain on 3/28/18.
 */

public class RandomHadithFragment extends Fragment {
    public static RandomHadithFragment newInstance(){
        RandomHadithFragment fragment=new RandomHadithFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.random_hadith_fragment,container,false);
        return view;
    }
}
