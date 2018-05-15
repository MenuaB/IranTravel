package com.example.android.irantravel.Classes;

import android.content.Context;
import android.content.Intent;

import com.example.android.irantravel.PlaceActivity;


/**
 * Created by meno on 5/1/2018.
 */

public class Navigation {
    public static void gotoPlace(Context context,Long placeId){
        Intent enterPlace = new Intent(context,PlaceActivity.class);
        enterPlace.putExtra(PlaceActivity.ARG_PLACE_ID,placeId);
        context.startActivity(enterPlace);
    }

}
