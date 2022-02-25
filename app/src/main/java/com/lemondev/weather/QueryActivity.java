package com.lemondev.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.MaterialToolbar;
import com.lemondev.weather.models.LocationModel;
import com.lemondev.weather.models.PlaceModel;
import com.lemondev.weather.request.WeatherApiClient;
import com.lemondev.weather.ui.adapters.OnPlaceItemClickListener;
import com.lemondev.weather.ui.adapters.PlaceAdapter;
import com.lemondev.weather.viewmodels.PlaceViewModel;

import java.util.ArrayList;
import java.util.List;

public class QueryActivity extends BaseActivity implements OnPlaceItemClickListener {

    private MaterialToolbar toolbar;

    private RecyclerView recyclerView;
    private PlaceAdapter placeAdapter;

    private PlaceViewModel placeViewModel;

    private Intent mIntent;

    private SearchView searchView;

    private ImageView background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.query_top_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        mIntent = getIntent();

        background = findViewById(R.id.query_background);
        background.setImageResource(R.drawable.background_sand);


        recyclerView = findViewById(R.id.query_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        placeAdapter = new PlaceAdapter(this);

        recyclerView.setAdapter(placeAdapter);

        ObserveQuery();
    }

    void query(String query) {
        WeatherApiClient.getInstance().query(query);
    }

    void ObserveQuery() {
        placeViewModel = new ViewModelProvider(this).get(PlaceViewModel.class);
        placeViewModel.getPlaces().observe(this, new Observer<List<PlaceModel>>() {
            @Override
            public void onChanged(List<PlaceModel> placeModels) {
                placeAdapter.setPlaces(placeModels);
            }
        });
    }


    @Override
    public void onPlaceChanged(PlaceModel placeModel) {
        //exit and refresh main page.
        Bundle bundle = new Bundle();
        bundle.putParcelable("placeModel", placeModel);
        mIntent.putExtra("place", bundle);
        setResult(AppCompatActivity.RESULT_OK, mIntent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.query_top_bar, menu);

        MenuItem menuItem = menu.findItem(R.id.query_search);
        searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //start query activity
                query(query);
                toolbar.setTitle(query);

//                searchView.clearFocus();
                invalidateOptionsMenu();        //recreate the menu
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}