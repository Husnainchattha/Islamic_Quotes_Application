package com.example.hussnain.islamicquotes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bullhead.quranquotes.domain.Verse;
import com.bullhead.quranquotes.views.QuranVerseView;
import com.example.hussnain.islamicquotes.Database.DatabaseeHelper;

/**
 * Created by hussnain on 3/28/18.
 */

public class RandomAyatFragment extends Fragment {

    private QuranVerseView quranVerseView;
    private TextView textView;
    private TextView textView1;
    public static RandomAyatFragment newInstance(){
        RandomAyatFragment fragment=new RandomAyatFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.random_ayat_fragment,container,false);
        quranVerseView=view.findViewById(R.id.randomVerseView);
        textView=view.findViewById(R.id.textarabic);
        Verse currentVerse=quranVerseView.getCurrentVerse();
        DatabaseeHelper dbHelper=new DatabaseeHelper(getContext());
        dbHelper.saveAyat(currentVerse.getArabic(),currentVerse.getEnglish());
        textView.setText(currentVerse.getArabic());
        return view;
    }
}
