package com.example.hussnain.islamicquotes;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class fragmentactivity extends AppCompatActivity implements fragment.Callback,FragmentTwo.Callback {
public FragmentTwo FragmentTwo;
    public EditText editText1;
    public EditText editText2;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentactivity);
        FragmentTwo =new FragmentTwo();
        fragmentManager=getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.secondfrm,new fragment())
                .addToBackStack("gf").commit();
    }
    String vavlue;
    @Override
    public void show() {
        editText1=findViewById(R.id.first);
        editText2=findViewById(R.id.second);
        int s = Integer.valueOf(editText1.getText().toString()) + Integer.valueOf(editText2.getText().toString());
        fragmentManager.beginTransaction().replace(R.id.secondfrm, FragmentTwo)
                .addToBackStack("deo").commit();
        vavlue=String.valueOf(s);
    }
    @Override
    public void viewCreated() {
        FragmentTwo.setText(vavlue);
    }
}
