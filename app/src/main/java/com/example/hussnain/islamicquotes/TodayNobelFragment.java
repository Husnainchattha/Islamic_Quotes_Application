package com.example.hussnain.islamicquotes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.hussnain.islamicquotes.Database.DatabaseeHelper;
import com.example.hussnain.islamicquotes.AyatPakage.ApiHandler;
import com.example.hussnain.islamicquotes.AyatPakage.Preferences;
import com.example.hussnain.islamicquotes.NobelPakage.NobelQuot;

import java.util.concurrent.TimeUnit;

/**
 * Created by hussnain on 3/28/18.
 */

public class TodayNobelFragment extends Fragment {
    public static TodayNobelFragment newInstance(){
        TodayNobelFragment fragment=new TodayNobelFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.today_nobel_fragment,container,false);
      final TextView quot=view.findViewById(R.id.Quote);
      final TextView writername=view.findViewById(R.id.writer);
      final ProgressBar progressBar=view.findViewById(R.id.nobleprograss);
      final Preferences preferences=Preferences.getInstance(getContext());
      ApiHandler.getInstance().getTodayNoble(new ApiHandler.MyCallback1(){
          @Override
          public void onSuccess(NobelQuot nobelQuot) {
              quot.setVisibility(View.VISIBLE);
              writername.setVisibility(View.VISIBLE);
              progressBar.setVisibility(View.GONE);
              quot.setText(nobelQuot.getContents().getQuotes().get(0).getQuote());
              writername.setText(nobelQuot.getContents().getQuotes().get(0).getAuthor());
             String save=quot.getText().toString();
              String save1=writername.getText().toString();
              preferences.saveTodayNoble(save);
              final String todaynoble=preferences.getSavedTodayNoble();
              if (save!=todaynoble){
                  DatabaseeHelper databaseayat= new DatabaseeHelper(getContext());
                  databaseayat.saveNoble(save,save1);
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
