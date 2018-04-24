package com.example.hussnain.islamicquotes;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bullhead.quranquotes.domain.hadith.Hadith;
import com.bullhead.quranquotes.views.HadithOfDayView;
import com.example.hussnain.islamicquotes.AyatPakage.Preferences;
import com.example.hussnain.islamicquotes.Database.DatabaseeHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by hussnain on 3/28/18.
 */

public class TodayHadithFragment extends Fragment {
    private HadithOfDayView hadithOfDayView;
    private  String savehadith;
    public static TodayHadithFragment newInstance(){
        TodayHadithFragment fragment=new TodayHadithFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.today_hadith_fragment,container,false);
       getActivity().setTitle(R.string.hadith);
        hadithOfDayView=view.findViewById(R.id.hadithofday);
        Hadith hadith=hadithOfDayView.getCurrentHadith();
        Preferences preferences = Preferences.getInstance(getContext());
        String hadith1=hadith.getText().toString();
        savehadith=preferences.getSavedTodayHadith();

        if (hadith1.equals(savehadith)) {
            Toast.makeText(getContext(),"if condition",Toast.LENGTH_LONG).show();
        }
        else {
            DatabaseeHelper databasehadith = new DatabaseeHelper(getContext());
            databasehadith.saveHadith(hadith.getText(), hadith.getBy());
            preferences.saveTodayhadith(hadith1);

        }
        return view;
    }
}
