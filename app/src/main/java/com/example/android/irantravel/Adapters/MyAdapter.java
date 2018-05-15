package com.example.android.irantravel.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.irantravel.Classes.Phrases;
import com.example.android.irantravel.R;

import java.util.List;

/**
 * Created by meno on 11/15/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<Phrases> phrase_list ;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            tv1= (TextView) itemView.findViewById(R.id.a_phrase);
            tv2= (TextView) itemView.findViewById(R.id.p_phrase);
            tv3= (TextView) itemView.findViewById(R.id.f_phrase);
        }
    }

    public MyAdapter(List<Phrases> list) {
        this.phrase_list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        final Phrases phrases = phrase_list.get(position);
        holder.tv1.setText(phrases.getA_Phrase());
        holder.tv2.setText(phrases.getP_Phrase());
        holder.tv3.setText(phrases.getF_Phrase());

    }

    @Override
    public int getItemCount() {
        return phrase_list.size();
    }

    interface hey{
        public int position(Phrases Model);
    }

}
