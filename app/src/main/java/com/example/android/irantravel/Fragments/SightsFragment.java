package com.example.android.irantravel.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.irantravel.Adapters.CategoryAdapter;
import com.example.android.irantravel.Adapters.MyAdapter;
import com.example.android.irantravel.Adapters.PlacesAdapter;
import com.example.android.irantravel.Classes.Category;
import com.example.android.irantravel.Classes.Navigation;
import com.example.android.irantravel.Classes.Phrases;
import com.example.android.irantravel.Classes.Places;
import com.example.android.irantravel.R;

import java.util.List;

import static com.example.android.irantravel.CityActivity.ARG_CIT;

/**
 * Created by meno on 11/26/2017.
 */

public class SightsFragment extends android.support.v4.app.Fragment implements PlacesAdapter.PlacesClickListener {

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.places, container, false);


        String a = getArguments().getString("ARG_CIT");
        //Log.d("City name",""+ a);




        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_views);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        List<Places> places_list = Places.find(Places.class,"CITY = ? and CATEGORY = ?",""+a,"Sights");
        PlacesAdapter adapter = new PlacesAdapter(places_list,this);
        mRecyclerView.setAdapter(adapter);
        //mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        return view;
    }


    @Override
    public void selectplace(Places model) {
        Navigation.gotoPlace(this.getActivity(),model.getId());
    }


}
