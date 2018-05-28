package com.example.android.irantravel;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.irantravel.Classes.Places;
import com.example.android.irantravel.gallery.GalleryFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlaceActivity extends AppCompatActivity {
    public static final String ARG_PLACE_ID = "PLACE_ID";


    TextView tvName;
    TextView tvType;
    TextView tvNumber;
    TextView tvWebsite;
    TextView tvWiki;
    TextView tvAddress;
    TextView tvDescription;
    ImageView ivMap;
    ImageView ivFirstImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_places);
//        setSupportActionBar(toolbar);

        ivFirstImage =  findViewById(R.id.pimage);
        tvName =  findViewById(R.id.p_name);
        tvType =  findViewById(R.id.p_type);
        tvNumber =  findViewById(R.id.p_number);
        tvWebsite =  findViewById(R.id.p_website);
        tvWiki =  findViewById(R.id.p_wiki);
        tvAddress =  findViewById(R.id.p_address);
        tvDescription =  findViewById(R.id.p_description);
        ivMap =  findViewById(R.id.p_map);



        long placeId = getIntent().getLongExtra(ARG_PLACE_ID, 0);
        final Places place = Places.find(Places.class, "ID = ?", "" + placeId).get(0);

        Picasso.with(this).load(place.getImage_1()).into(ivFirstImage);
        tvName.setText(place.getName());
        tvType.setText(place.getType());
        tvNumber.setText("Phone Number"+place.getnumber());
        tvWebsite.setText(place.getWebsite());

        tvWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse(place.getWebsite()));
                startActivity(browser);
            }
        });

        tvWiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse(place.getWiki()));
                startActivity(browser);
            }
        });
        tvAddress.setText(place.getAddress());
        tvDescription.setText(place.getDescription());
        String imgURL = place.getMap();
        Picasso.with(this).load(imgURL).into(ivMap);


        final ArrayList<String> list = new ArrayList<>();
        String entry1= place.getImage_1();
        String entry2= place.getImage_2();
        String entry3= place.getImage_3();
        String entry4= place.getImage_4();
        list.add(entry1);
        list.add(entry2);
        list.add(entry3);
        list.add(entry4);




        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GalleryFragment.newInstance(list,0).show(getSupportFragmentManager(),"a;fkjd");
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
