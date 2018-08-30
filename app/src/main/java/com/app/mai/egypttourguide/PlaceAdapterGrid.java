package com.app.mai.egypttourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapterGrid extends ArrayAdapter<Place>{
    public PlaceAdapterGrid(@NonNull Context context, ArrayList<Place> myPlace) {
        super(context,0, myPlace);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // in case of nothing to use as onCreate level
        // i.e convertView = null
        // ---> make view(convertView)=LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false)

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_grid, parent, false);

        }
// define the position of the item
        final Place currentPlace = getItem(position);

        // set image
        ImageView imageView = convertView.findViewById(R.id.image);
        imageView.setImageResource(currentPlace.getImageView());

        // set place name
        TextView placeName = convertView.findViewById(R.id.place_name);
        placeName.setText(currentPlace.getPlaceName());

        // set place location
        TextView placeLocation = convertView.findViewById(R.id.place_location);
        placeLocation.setText(currentPlace.getPlaceLocation());

        return convertView;
    }


}
