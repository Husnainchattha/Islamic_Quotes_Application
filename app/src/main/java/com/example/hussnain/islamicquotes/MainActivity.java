package com.example.hussnain.islamicquotes;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private Ayat ayatFragment;
    private Hadith hadithFragment;
    private Nobel nobelFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomnavigationbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.todayitem:
                        if (ayatFragment==null){
                            ayatFragment=Ayat.newInstance();

                        }
                        selectedFragment = ayatFragment;
                        break;
                    case R.id.randomitem2:
                        if (hadithFragment==null){
                            hadithFragment=Hadith.newInstance();
                        }
                        selectedFragment = hadithFragment;
                        break;
                    case R.id.previousitem:
                        if (nobelFragment==null){
                            nobelFragment=Nobel.newInstance();
                        }
                        selectedFragment = nobelFragment;
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.framone, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        ayatFragment=Ayat.newInstance();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framone, Ayat.newInstance());
        transaction.commit();
    }

    @Override
    public void setActionBar(@Nullable Toolbar toolbar) {
        super.setActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.ayat);
    }
}

