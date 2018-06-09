package com.example.android.irantravel.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.example.android.irantravel.Classes.Category;
import com.example.android.irantravel.Classes.Places;
import com.example.android.irantravel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import static android.content.ContentValues.TAG;
import static com.example.android.irantravel.R.id.imageView;


/**
 * Created by meno on 12/12/2017.
 */

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {
    PlacesClickListener listener;
    List<Places> places_list;



    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView iv1;
        public TextView tv1;
        public TextView tv3;
        public ViewHolder(View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.sight_image);
            tv1 = itemView.findViewById(R.id.sight_name);
            tv3 = itemView.findViewById(R.id.sight_address);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.selectplace(places_list.get(getAdapterPosition()));
                }
            });

        }
    }

    public PlacesAdapter(List<Places> list,PlacesClickListener listener){
        this.places_list = list;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_item,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        final Places places = places_list.get(position);
        holder.tv1.setText(places.getName());
        holder.tv3.setText(places.getAddress());
        Picasso.with(holder.iv1.getContext()).load(places.getImage_1()).into(holder.iv1);

    }

    @Override
    public int getItemCount() {
        return places_list.size();
    }

    public interface PlacesClickListener{
        void selectplace(Places model);
    }


}
