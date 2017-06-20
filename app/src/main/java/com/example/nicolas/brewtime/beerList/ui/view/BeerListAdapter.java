package com.example.nicolas.brewtime.beerList.ui.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nicolas.brewtime.R;
import com.example.nicolas.brewtime.beerList.ui.viewmodel.base.BeerBaseViewModel;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class BeerListAdapter extends RecyclerView.Adapter<BeerListAdapter.ViewHolder> {

    List<BeerBaseViewModel> beerList;
    Context context;

    public BeerListAdapter(List<BeerBaseViewModel> beerList) {
        this.beerList = beerList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.beer_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.beerName.setText(beerList.get(position).getName());
        holder.beerDate.setText(beerList.get(position).getBrewDate());
        Picasso.with(context)
                .load(context.getResources().getIdentifier(beerList.get(position).getIconPath(), "drawable", context.getPackageName()))
                .placeholder(R.drawable.beer_icon_blonde)
                .fit()
                .centerCrop()
                .into(holder.beerIcon);
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView beerName, beerDate;
        private ImageView beerIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            beerName = (TextView) itemView.findViewById(R.id.beer_name_list);
            beerDate = (TextView) itemView.findViewById(R.id.beer_date_list);
            beerIcon = (ImageView) itemView.findViewById(R.id.beer_icon_list);
        }
    }
}
