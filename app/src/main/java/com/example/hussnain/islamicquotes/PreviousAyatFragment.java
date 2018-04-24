package com.example.hussnain.islamicquotes;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hussnain.islamicquotes.Database.DatabaseeHelper;

import java.util.ArrayList;

/**
 * Created by hussnain on 3/28/18.
 */

public class PreviousAyatFragment extends Fragment {
    private Context context;
    private RecyclerView recyclerView;

    public static PreviousAyatFragment newInstance(){
        PreviousAyatFragment fragment=new PreviousAyatFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.previous_ayat_fragment,container,false);
        DatabaseeHelper helper=new DatabaseeHelper(getContext());
        ArrayList<DataBaseAyat> ayats=helper.getAllAyat();
        recyclerView=view.findViewById(R.id.ayatrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        OurAdapter ourAdapter=new OurAdapter(ayats);
        recyclerView.setAdapter(ourAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{
        private final ArrayList<DataBaseAyat> data;
        public OurAdapter(ArrayList<DataBaseAyat> data) {
            this.data=data;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false));
        }
        @Override
        public void onBindViewHolder( ViewHolder holder, int position) {
          DataBaseAyat ayat=data.get(position);
          holder.textView.setText(ayat.getRandomayat());
          holder.textView1.setText(ayat.getAyat());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            TextView textView1;
            public ViewHolder(View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.ayatarbi);
                 textView1=itemView.findViewById(R.id.ayatenglish);
            }
        }
    }
}
