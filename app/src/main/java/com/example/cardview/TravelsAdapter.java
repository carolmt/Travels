package com.example.cardview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TravelsAdapter extends RecyclerView.Adapter<TravelsAdapter.ViewHolder> {

    private List<Integer> fotosTravel;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView img;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.travelImg);
        }

        public ImageView getImg() {
            return img;
        }

    }

    public TravelsAdapter(List<Integer> fotosTravel) {
        this.fotosTravel = fotosTravel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.travel_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        int imageResource = fotosTravel.get(position);

        // Establece la imagen en el ImageView
        viewHolder.img.setImageResource(imageResource);
        // OnClickListener para realizar acciones cuando se hace clic en una imagen
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageSwitcher imageSwitcher = v.getRootView().findViewById(R.id.switcherTravels);
                imageSwitcher.setImageResource(imageResource);

            }
        });
    }

        @Override
        public int getItemCount () {
            return fotosTravel.size();
        }
    }

