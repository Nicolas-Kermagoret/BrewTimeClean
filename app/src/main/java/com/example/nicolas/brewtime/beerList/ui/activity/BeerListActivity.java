package com.example.nicolas.brewtime.beerList.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.nicolas.brewtime.R;
import com.example.nicolas.brewtime.beerList.presenter.BeerListPresenter;
import com.example.nicolas.brewtime.beerList.presenter.base.BaseListPresenter;
import com.example.nicolas.brewtime.beerList.repository.BeerRepository;
import com.example.nicolas.brewtime.beerList.repository.base.BeerBaseRepository;
import com.example.nicolas.brewtime.beerList.ui.view.BaseListView;
import com.example.nicolas.brewtime.beerList.ui.view.BeerListAdapter;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.BeerBaseViewModel;
import com.example.nicolas.brewtime.beerList.usecase.GetBeerListUseCase;
import com.example.nicolas.brewtime.beerList.usecase.base.GetBeerListBaseUseCase;
import com.example.nicolas.brewtime.beerdetails.ui.activity.BeerDetailsActivity;
import com.example.nicolas.brewtime.common.view.SimpleDividerItemDecoration;

import java.util.List;

public class BeerListActivity extends AppCompatActivity implements BaseListView, BeerListAdapter.BeerListItemListener {

    private static final String TAG = BeerListActivity.class.getName();
    public static final String BEER_EXTRA = "beer_extra";

    private BaseListPresenter presenter;
    private BeerListAdapter adapter;
    private RecyclerView recyclerView;

    private List<BeerBaseViewModel> beerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BeerBaseRepository repository = new BeerRepository(this);
        final GetBeerListBaseUseCase useCase = new GetBeerListUseCase(repository);
        this.presenter = new BeerListPresenter(useCase, this);
        this.presenter.onViewAttached(this);

        this.recyclerView = (RecyclerView) this.findViewById(R.id.recycler_view_beer_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        this.presenter.getBeers();

//        SharedPreferences sharedPreferences = getSharedPreferences(BeerRepository.prefsName, MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(BeerRepository.sharedPrefName, "{\n" +
//                "  \"size\":2,\n" +
//                "  \"beerList\": [\n" +
//                "    {\n" +
//                "      \"name\": \"IPA 1\",\n" +
//                "      \"type\": \"IPA\",\n" +
//                "      \"quantity\": \"50\",\n" +
//                "      \"brewDate\" : \"27/11/2016\",\n" +
//                "      \"secondFermentationDate\" : \"07/12/2016\",\n" +
//                "      \"gardeDate\" : \"10/12/2016\",\n" +
//                "      \"bottlingDate\" : \"12/12/2016\",\n" +
//                "      \"drinkingDate\" : \"25/12/2016\",\n" +
//                "      \"ingredientList\": [\n" +
//                "       {\n" +
//                "          \"type\":\"malt\",\n" +
//                "          \"name\":\"pils\",\n" +
//                "          \"quantity\":\"5000\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"malt\",\n" +
//                "          \"name\":\"cara\",\n" +
//                "          \"quantity\":\"1500\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"houblonAM\",\n" +
//                "          \"name\":\"zeus\",\n" +
//                "          \"quantity\":\"60\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"houblonAR\",\n" +
//                "          \"name\":\"cascade\",\n" +
//                "          \"quantity\":\"60\"\n" +
//                "        },\n" +
//                "       {\n" +
//                "          \"type\":\"epice\",\n" +
//                "          \"name\":\"graine de coriandre\",\n" +
//                "          \"quantity\":\"30\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"levure\",\n" +
//                "          \"name\":\"top\",\n" +
//                "          \"quantity\":\"10\"\n" +
//                "        }]\n" +
//                "      \n" +
//                "  },\n" +
//                "      {\n" +
//                "      \"name\": \"Stout 1\",\n" +
//                "      \"type\": \"Stout\",\n" +
//                "      \"quantity\": \"50\",\n" +
//                "      \"brewDate\" : \"27/11/2015\",\n" +
//                "      \"secondFermentationDate\" : \"07/12/2015\",\n" +
//                "      \"gardeDate\" : \"10/12/2015\",\n" +
//                "      \"bottlingDate\" : \"12/12/2015\",\n" +
//                "      \"drinkingDate\" : \"25/12/2015\",\n" +
//                "      \"ingredientList\": [\n" +
//                "       {\n" +
//                "          \"type\":\"malt\",\n" +
//                "          \"name\":\"pils\",\n" +
//                "          \"quantity\":\"5000\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"malt\",\n" +
//                "          \"name\":\"chocolat\",\n" +
//                "          \"quantity\":\"1500\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"houblonAM\",\n" +
//                "          \"name\":\"zeus\",\n" +
//                "          \"quantity\":\"60\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"houblonAR\",\n" +
//                "          \"name\":\"cascade\",\n" +
//                "          \"quantity\":\"60\"\n" +
//                "        },\n" +
//                "       {\n" +
//                "          \"type\":\"epice\",\n" +
//                "          \"name\":\"graine de coriandre\",\n" +
//                "          \"quantity\":\"30\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\":\"levure\",\n" +
//                "          \"name\":\"top\",\n" +
//                "          \"quantity\":\"10\"\n" +
//                "        }]\n" +
//                "      \n" +
//                "  }\n" +
//                "  ]\n" +
//                "}");
//        editor.commit();
    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void setResponse(List<BeerBaseViewModel> beerBaseViewModels) {
        this.adapter = new BeerListAdapter(beerBaseViewModels, this);
        this.beerList = beerBaseViewModels;
        this.recyclerView.setAdapter(adapter);
    }

    @Override
    public void loading(boolean isLoading) {

    }

    @Override
    public void onNoNetwork() {

    }

    @Override
    public void setEmptyResponse() {

    }

    @Override
    public void itemClicked(int position) {
        Intent intent = new Intent(this, BeerDetailsActivity.class);
        intent.putExtra(this.BEER_EXTRA, beerList.get(position));
        startActivity(intent);
    }
}
