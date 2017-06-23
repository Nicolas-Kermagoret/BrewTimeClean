package com.example.nicolas.brewtime.beerdetails.ui.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.nicolas.brewtime.R;
import com.example.nicolas.brewtime.beerList.ui.activity.BeerListActivity;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.BeerBaseViewModel;

public class BeerDetailsActivity extends AppCompatActivity {

    private static final String TAG = BeerDetailsActivity.class.getName();

    BeerBaseViewModel beerVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_details);

        Intent intent = getIntent();
        this.beerVM = (BeerBaseViewModel)intent.getSerializableExtra(BeerListActivity.BEER_EXTRA);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(beerVM.getName());

    }
}
