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
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


public class FragmentGreenArea extends Fragment {
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// @param changed for each fragment
        int fragmentLayout = R.layout.fragment_green_area;
        int listId = R.id.green_area_list;
        // type of list
        GridView listView;
        // type of adapter
        PlaceAdapterGrid adapter;

        // change action bar title
        getActivity().setTitle("Green Area");

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(fragmentLayout, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        // int imageView, String placeName, String placeLocation, String howToSpeakItLikeArabic, String mapLocation, String locationAddress
        places.add(new Place(R.drawable.hadiqat_alazhar,"Al-Azhar Park", "Cairo", "hadiqat al'azhar","geo:30.0404369,31.2600978?z=16","Salah Salem St, El-Darb El-Ahmar, Cairo"));
        places.add(new Place(R.drawable.hadiqat_alusra,"Family Park", "Cairo", "hadiqat al'usra","geo:30.0823541,31.4974661?z=16","Suez Rd, Cairo"));
        places.add(new Place(R.drawable.alhadiqat_alduwaliuh,"International Garden", "Cairo", "alhadiqat alduwaliuh","geo:30.0442091,31.3265169?z=15","Passage Inside National Park, Al Hadiqah Ad Dawleyah, Nasr City, Cairo"));
        places.add(new Place(R.drawable.hadiqat_alfstat,"Fostat Park", "Cairo", "hadiqat alfstat","geo:30.0146493,31.2454316,21z?z=30.0146493,31.2454316,21","Ein as Seirah, Misr Al Qadimah, Cairo"));



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
