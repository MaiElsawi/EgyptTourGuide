package com.app.mai.egypttourguide;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class FragmentMainScreen extends Fragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // @param changed for each fragment
        int fragmentLayout = R.layout.fragment_main_screen_list;
        int listId = R.id.main_screen_list;
        // type of list
        GridView listView;
        // type of adapter
        PlaceAdapterGrid adapter;

        // change action bar title
        getActivity().setTitle("Home");

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(fragmentLayout, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        // int imageView, String placeName, String placeLocation, String howToSpeakItLikeArabic, String mapLocation, String locationAddress
        places.add(new Place(R.drawable.taba,"Taba", "South Sinai", "","geo:29.4934581,34.887118?z=15","South Sinai Government"));
        places.add(new Place(R.drawable.sahl_hashish,"Sahl Hashish", "Red Sea", "","geo:27.0299286,33.8378815?z=13","Red Sea Government"));
        places.add(new Place(R.drawable.al_alameen,"Al-Alameen", "Matrouh", "","geo:30.8224683,28.9367994?z=14","Matrouh Government"));
        places.add(new Place(R.drawable.sharm_al_sheikh,"Sharm Al-sheikh", "South Sinai", "","geo:27.9650372,34.212492?z=11","South Sinai Government"));
        places.add(new Place(R.drawable.hourgada,"Hourgada", "Red Sea", "Al-ghardaqua","geo:27.1922261,33.5015195?z=10","Red Sea Government"));
        places.add(new Place(R.drawable.alexandria,"Alexandria", "Alexandria", "Al-eskandaria","geo:31.2240349,29.8148008?z=11","Alexandria Government"));
        places.add(new Place(R.drawable.aswan,"Aswan", "Aswan", "","geo:24.0923336,32.8825966?z=14","Aswan Government"));
        places.add(new Place(R.drawable.luxor,"Luxor", "Luxor", "","geo:25.694937,32.6244474?z=13","Luxor Government"));

        // grid adapter
        adapter = new PlaceAdapterGrid(getActivity(), places);

        listView = rootView.findViewById(listId);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //                getActivity().setTitle("Info");


                // get the position from onItemClick constructor for each "place"item
                // and save the position on a variable called "placeItem" with data type "Place"
                Place placeItem = places.get(position);

                // move to details Activity
                // 1- set intent instance
                Intent intent = new Intent(getActivity(), Details.class);

                /* 2- save values to pass to the next activity
                 what we need to pass:
                 @ int imageView,
                 @ String placeName,
                 @ String placeLocation,
                 @ String howToSpeakItLikeArabic,
                 @ String mapLocation
                 @ String locationAddress
                 */
                intent.putExtra("imageView", placeItem.getImageView());
                intent.putExtra("placeName", placeItem.getPlaceName());
                intent.putExtra("placeLocation", placeItem.getPlaceLocation());
                intent.putExtra("howToSpeakItLikeArabic", placeItem.getHowToSpeakItLikeArabic());
                intent.putExtra("mapLocation", placeItem.getMapLocation());
                intent.putExtra("locationAddress", placeItem.getLocationAddress());

                // 3- start intent
                startActivity(intent);
            }
        });

        return rootView;
    }


}
