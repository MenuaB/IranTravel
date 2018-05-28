package com.example.android.irantravel;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.android.irantravel.Adapters.MyAdapter;
import com.example.android.irantravel.Classes.Category;
import com.example.android.irantravel.Classes.Phrases;
import com.example.android.irantravel.R;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

public class PhrasesList extends AppCompatActivity {
    public static final String ARG_CAT = "item_category";

    private RecyclerView mRecyclerView;
    private MaterialSearchView searchView;
    private List<Phrases> phrases_list;
    private MyAdapter adapter;
    private Intent i;
    private String p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases_list);


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Words");
        setSupportActionBar(toolbar);


        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Phrases> list = Phrases.findWithQuery(Phrases.class, "Select * from Phrases where APHRASE like '%" + query + "%'");
                if (list.size() < 1)
                    return false;

                phrases_list.clear();
                phrases_list.addAll(list);
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

//        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

        i = getIntent();
        p = i.getStringExtra(ARG_CAT);

        mRecyclerView = findViewById(R.id.phrases_list_recycler_view);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        phrases_list = Phrases.find(Phrases.class, "CATEGORY = ?", "" + p);
        adapter = new MyAdapter(phrases_list);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        List<Phrases> list = Phrases.find(Phrases.class, "CATEGORY = ?", "" + p);
        phrases_list.clear();
        phrases_list.addAll(list);
        adapter.notifyDataSetChanged();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);
        return super.onCreateOptionsMenu(menu);
    }
}
