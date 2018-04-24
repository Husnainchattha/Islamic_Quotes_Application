package com.example.hussnain.islamicquotes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hussnain.islamicquotes.AyatPakage.ApiHandler;
import com.example.hussnain.islamicquotes.AyatPakage.BaseResponse;
import com.example.hussnain.islamicquotes.AyatPakage.Preferences;
import com.example.hussnain.islamicquotes.Database.DatabaseeHelper;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hussnain on 3/28/18.
 */

public class TodayAyatFragment extends Fragment {
    private static TodayAyatFragment instance;
    SharedPreferences sharedPreferences;
    public static final String ayat = "ayat";

    public static TodayAyatFragment newInstance() {

        TodayAyatFragment fragment = new TodayAyatFragment();
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.today_ayat_fragment, container, false);
        final TextView textView = view.findViewById(R.id.todayat);
        final TextView textView2 = view.findViewById(R.id.todayatname);
        final TextView textView1 = view.findViewById(R.id.date);
        final ProgressBar progressBar = view.findViewById(R.id.prograss);
         getActivity().setTitle("Ayat");
        //check if already generated random today
        Preferences preferences = Preferences.getInstance(getContext());
        final long savedTime = preferences.getSavedTime();
        final long todayTime = System.currentTimeMillis();
        int random = preferences.getRandomNumber();

        if ((todayTime - savedTime) >= TimeUnit.DAYS.toMillis(1)) {
            random = new Random().nextInt(6236) + 1;
            preferences.saveTodayTime(random);

        }
        else if (savedTime - todayTime +3600 >TimeUnit.DAYS.toMillis(1)){
            random = new Random().nextInt(6236) + 1;
            preferences.saveTodayTime(random);
        }

        ApiHandler.getInstance().getTodayAyah(random, new ApiHandler.MyCallback() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                textView.setVisibility(View.VISIBLE);
                textView2.setVisibility(View.VISIBLE);
                textView1.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                textView.setText(baseResponse.getData().getText());
                String mytime = (DateFormat.format("dd/MM/yyyy", new java.util.Date()).toString());
                textView1.setText(mytime);
                textView2.setText(baseResponse.getData().getSurah().getName() + " | " + String.valueOf(baseResponse.getData().getSurah().getNumber()));
               String saveayat = textView.getText().toString();
               String savewrtr = textView2.getText().toString();
               if ((todayTime-savedTime) >= TimeUnit.DAYS.toMillis(1)) {
                   DatabaseeHelper databaseayat= new DatabaseeHelper(getContext());
                databaseayat.saveAyat(saveayat,savewrtr);
            }
            }
            @Override
            public void onError(String message) {
                progressBar.setVisibility(View.GONE);
            }
        });
        return view;
    }
}
