package com.example.hussnain.islamicquotes;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class fragmentactivity extends AppCompatActivity implements fragment.Callback {
public fragmenttwo fragmenttwo;
    public EditText editText1;
    public EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentactivity);
        fragmenttwo =new fragmenttwo();
        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.firstfrm,fragmenttwo).commit();
        fragmentManager.beginTransaction().replace(R.id.secondfrm,new fragment()).commit();
    }

    @Override
    public void show() {
        editText1=findViewById(R.id.first);
        editText2=findViewById(R.id.second);

        Integer s = Integer.valueOf(editText1.getText().toString()) + Integer.valueOf(editText2.getText().toString());
        fragmenttwo.setText(String.valueOf(s));
    }
}
