package com.example.hussnain.islamicquotes;


import android.content.Context;
import android.os.Bundle;
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

public class PreviousNobelFragment extends Fragment {
    private RecyclerView recyclerView;
    private Context context;
    public static PreviousNobelFragment newInstance(){
        PreviousNobelFragment fragment=new PreviousNobelFragment();
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.previous_nobel_fragment,container,false);
        DatabaseeHelper helper=new DatabaseeHelper(getContext());
       ArrayList<DataBaseNoble> nobles=helper.getAllNoble();
      recyclerView=view.findViewById(R.id.noblerecyclerview);
      recyclerView.setLayoutManager(new LinearLayoutManager(context));
      OurAdapter adapter=new OurAdapter(nobles);
      recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        this.context=context;
    }

    public class OurAdapter extends RecyclerView.Adapter<OurAdapter.ViewHolder>{
        private final ArrayList<DataBaseNoble> data;
        public OurAdapter(ArrayList<DataBaseNoble> data){
            this.data=data;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
             DataBaseNoble noble=data.get(position);
            holder.textView.setText(noble.getQuotby());
            holder.textView1.setText(noble.getWriterby());
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            public TextView textView1;
            public ViewHolder(View itemView) {
                super(itemView);
                textView=itemView.findViewById(R.id.ayatarbi);
                textView1=itemView.findViewById(R.id.ayatenglish);
            }
        }
    }
}
