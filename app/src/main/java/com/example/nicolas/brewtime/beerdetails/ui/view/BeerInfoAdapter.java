package com.example.nicolas.brewtime.beerdetails.ui.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nicolas.brewtime.R;
import com.example.nicolas.brewtime.beerdetails.ui.viewmodel.base.BeerInfoItemBaseViewModel;

import java.util.List;

public class BeerInfoAdapter extends RecyclerView.Adapter<BeerInfoAdapter.ViewHolder> {

    private List<BeerInfoItemBaseViewModel> infoList;

    public BeerInfoAdapter(List<BeerInfoItemBaseViewModel> infoList) {
        this.infoList = infoList;
    }

    @Override
    public BeerInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_info_item, parent, false);
        return new BeerInfoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BeerInfoAdapter.ViewHolder holder, final int position) {
        holder.beerInfo.setText(infoList.get(position).getInfo());
        holder.beerInfoValue.setText(infoList.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView beerInfo, beerInfoValue;

        public ViewHolder(View itemView) {
            super(itemView);

            beerInfo = (TextView) itemView.findViewById(R.id.beer_info);
            beerInfoValue = (TextView) itemView.findViewById(R.id.beer_info_value);
        }
    }
}
