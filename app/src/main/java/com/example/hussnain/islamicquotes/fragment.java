package com.example.hussnain.islamicquotes;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hussnain on 3/20/18.
 */

public class fragment extends Fragment{
    public EditText editText1;
    public EditText editText2;
    private Button btn;
    private TextView textView;
    public String data;
    public  String a=null;
    public interface Callback{
        void show();
    }
    private Callback callback;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback=(Callback)context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view=inflater.inflate(R.layout.testtwo,container,false);
        editText1=view.findViewById(R.id.first);
        editText2=view.findViewById(R.id.second);
        btn=view.findViewById(R.id.btnadd);
       // textView=view.findViewById(R.id.fresult);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.show();
            }
        });
  return view;
    }

}
