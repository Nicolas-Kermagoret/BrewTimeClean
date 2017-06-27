package com.example.nicolas.brewtime.beerdetails.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nicolas.brewtime.R;
import com.example.nicolas.brewtime.beerList.ui.activity.BeerListActivity;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.BeerBaseViewModel;
import com.example.nicolas.brewtime.beerdetails.ui.view.BeerInfoAdapter;
import com.example.nicolas.brewtime.beerdetails.ui.viewmodel.BeerInfoItemViewModel;
import com.example.nicolas.brewtime.beerdetails.ui.viewmodel.base.BeerInfoItemBaseViewModel;

import java.util.ArrayList;
import java.util.List;

public class BeerDetailsActivity extends AppCompatActivity {

    private static final String TAG = BeerDetailsActivity.class.getName();

    private BeerBaseViewModel beerVM;

    private BeerInfoAdapter infosAdapter;
    private BeerInfoAdapter datesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_details);

        Intent intent = getIntent();
        this.beerVM = (BeerBaseViewModel) intent.getSerializableExtra(BeerListActivity.BEER_EXTRA);

        this.initView();
    }

    public void initView() {

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.findViewById(R.id.collapsing_toolbar);
        RecyclerView infosRecycler = (RecyclerView) this.findViewById(R.id.recycler_view_infos);
        RecyclerView datesRecycler = (RecyclerView) this.findViewById(R.id.recycler_view_dates);

        RecyclerView.LayoutManager layoutManagerInfos = new LinearLayoutManager(this.getApplicationContext());
        RecyclerView.LayoutManager layoutManagerDates = new LinearLayoutManager(this.getApplicationContext());

        infosRecycler.setLayoutManager(layoutManagerInfos);
        datesRecycler.setLayoutManager(layoutManagerDates);
        collapsingToolbarLayout.setTitle(beerVM.getName());

        List<BeerInfoItemBaseViewModel> infos = new ArrayList<BeerInfoItemBaseViewModel>();
        infos.add(new BeerInfoItemViewModel(getResources().getString(R.string.beer_type), beerVM.getType()));
        infos.add(new BeerInfoItemViewModel(getResources().getString(R.string.beer_quantity), beerVM.getQuantity()));
        infosAdapter = new BeerInfoAdapter(infos);
        infosRecycler.setAdapter(infosAdapter);

        List<BeerInfoItemBaseViewModel> dates = new ArrayList<BeerInfoItemBaseViewModel>();
        dates.add(new BeerInfoItemViewModel(getResources().getString(R.string.beer_date_brewing), beerVM.getBrewDate()));
        dates.add(new BeerInfoItemViewModel(getResources().getString(R.string.beer_date_second), beerVM.getSecondFermentationDate()));
        dates.add(new BeerInfoItemViewModel(getResources().getString(R.string.beer_date_garde), beerVM.getGardeDate()));
        dates.add(new BeerInfoItemViewModel(getResources().getString(R.string.beer_date_bottling), beerVM.getBottlingDate()));
        dates.add(new BeerInfoItemViewModel(getResources().getString(R.string.beer_date_drinking), beerVM.getDrinkingDate()));
        datesAdapter = new BeerInfoAdapter(dates);
        datesRecycler.setAdapter(datesAdapter);

    }
}
