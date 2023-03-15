package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Adapter.AdapterFavourite;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.R;
import com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Constant.Constant;

public class ActivityFavourite extends AppCompatActivity {

    RecyclerView recycler_favourite;
    AdapterFavourite adapterFavourite;
    FrameLayout Frame_search_no_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        recycler_favourite = findViewById(R.id.recycler_favourite);
        Frame_search_no_data = findViewById(R.id.Frame_search_no_data);
        recycler_favourite.setLayoutManager(new GridLayoutManager(this, 4));
        adapterFavourite = new AdapterFavourite(this);
        recycler_favourite.setAdapter(adapterFavourite);

    }


    @Override
    protected void onResume() {
        super.onResume();
        adapterFavourite.notifyDataSetChanged();
        if (Constant.arrayListFavourite.size() < 1) {
            Frame_search_no_data.setVisibility(View.VISIBLE);
        }else {
            Frame_search_no_data.setVisibility(View.GONE);
        }
    }
}