package com.example.hussnain.islamicquotes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hussnain on 3/20/18.
 *
 */

public class FragmentTwo extends Fragment {
    public interface Callback{
        void viewCreated();
    }
    private Callback callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback=(Callback)context;
    }

    public TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.test,container,false);
         textView=view.findViewById(R.id.result);
        return view;
    }
    public void setText(String text){
        textView.setText(text);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        callback.viewCreated();
    }


}
