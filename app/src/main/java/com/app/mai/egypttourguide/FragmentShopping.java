package com.app.mai.egypttourguide;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class FragmentShopping extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// @param changed for each fragment
        int fragmentLayout = R.layout.fragment_shopping;
        int listId = R.id.shopping_list;
// type of list
        ListView listView;
// type of adapter
        PlaceAdapterList adapter;
// change action bar title
        getActivity().setTitle("Shopping Places");

// Inflate the layout for this fragment
        View rootView = inflater.inflate(fragmentLayout, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        // int imageView, String placeName, String placeLocation, String howToSpeakItLikeArabic, String mapLocation, String locationAddress
        places.add(new Place(R.drawable.khan_alkhalili,"Khan el-Khalili", "Cairo", "khan alkhalili","geo:30.047875,31.2622565,21z?z=30.047875,31.2622565,21","El-Gamaleya, Qism El-Gamaleya, Cairo"));
        places.add(new Place(R.drawable.sharie_almaez,"Al-Moez Street", "Cairo", "sharie almaez","geo:30.0510356,31.2612931,21z?z=30.0510356,31.2612931,21","El-Gamaleya, Qism El-Gamaleya, Cairo"));
        places.add(new Place(R.drawable.sharie_alghuria,"Al-Quria Street", "Cairo", "sharie alghuria","geo:30.0444831,31.2576771,21z?z=30.0444831,31.2576771,21","El-Darb El-Ahmar, Cairo"));
        places.add(new Place(R.drawable.siti_starz,"City Stars", "Cairo", "siti starz","geo:30.0726076,31.3441225,21z?z=30.0726076,31.3441225,21","Masaken Al Mohandesin, Nasr City, Cairo"));
        places.add(new Place(R.drawable.mawalu_alearab,"Mall of Arabia", "Cairo", "mawalu alearab","geo:30.0062993,30.9734805,21z?z=30.0062993,30.9734805,21","26th of July Corridor, Giza"));


        // list adapter
        adapter = new PlaceAdapterList(getActivity(), places);

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
