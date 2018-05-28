package com.example.android.irantravel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.irantravel.Adapters.CategoryAdapter;
import com.example.android.irantravel.Classes.Category;
import com.example.android.irantravel.Classes.Phrases;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CategoryAdapter.DataSelectListener {


    private MaterialSearchView searchView;
    private RecyclerView mRecyclerView;
    private List<Category> categories_list;
    private CategoryAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //getAssets()
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        toolbar.setTitle("Words Category");
        setSupportActionBar(toolbar);

        searchView =  findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                List<Category> list = Category.findWithQuery( Category.class, "Select * from Category where ACATEGORY like '%"+query+"%'" );
                if (list.size()<1)
                    return false;

                categories_list.clear();
                categories_list.addAll(list);
                adapter.notifyDataSetChanged();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        mRecyclerView =  findViewById(R.id.recycler_view);
        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categories_list = Category.listAll(Category.class);
        adapter = new CategoryAdapter(categories_list, this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));


    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (doubleBackToExitPressedOnce) {
                super.onBackPressed();
                finish();
                System.exit(0);
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    doubleBackToExitPressedOnce=false;
                }
            }, 2000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.tehran) {
            Intent enterCity = new Intent(this, CityActivity.class);
            String a = "Tehran";
            enterCity.putExtra(CityActivity.ARG_CIT, a);
            startActivity(enterCity);
        } else if (id == R.id.isfahan) {
            Intent enterCity = new Intent(this, CityActivity.class);
            String a = "Isfahan";
            enterCity.putExtra(CityActivity.ARG_CIT, a);
            startActivity(enterCity);
        } else if (id == R.id.tabriz) {
            Intent enterCity = new Intent(this, CityActivity.class);
            String a = "Tabriz";
            enterCity.putExtra(CityActivity.ARG_CIT, a);
            startActivity(enterCity);
        } else if (id == R.id.shiraz) {
            Intent enterCity = new Intent(this, CityActivity.class);
            String a = "Shiraz";
            enterCity.putExtra(CityActivity.ARG_CIT, a);
            startActivity(enterCity);
        }
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void selectData(Category model, String p) {
        Intent enterMain = new Intent(this, PhrasesList.class);
        enterMain.putExtra(PhrasesList.ARG_CAT, p);
        startActivity(enterMain);

    }


}
