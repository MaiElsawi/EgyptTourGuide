package com.app.mai.egypttourguide;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class FragmentHistorical extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// @param changed for each fragment
        int fragmentLayout = R.layout.fragment_historical;
        int listId = R.id.historical_list;
// type of list
        ListView listView;
// type of adapter
        PlaceAdapterList adapter;
// change action bar title
        getActivity().setTitle("Historical Places");


// Inflate the layout for this fragment
        View rootView = inflater.inflate(fragmentLayout, container, false);

        final ArrayList<Place> places = new ArrayList<>();
        // int imageView, String placeName, String placeLocation, String howToSpeakItLikeArabic, String mapLocation, String locationAddress
        places.add(new Place(R.drawable.almutahaf_almisriu,"Egyptian Museum", "Giza", "almutahaf almisriu","geo:30.0478468,31.2336493?z=15","15 Meret Basha, Ismailia, Qasr an Nile, Cairo"));
        places.add(new Place(R.drawable.abu_alhul,"The Great Sphinx of Giza", "Giza", "abu alhul","geo:29.9752687,31.1375674?z=15","Al Haram, Giza"));
        places.add(new Place(R.drawable.ahramat_aljizih,"Giza Pyramid", "Giza", "ahramat aljizih","geo:29.9772962,31.1324955?z=15","Al Haram, Giza"));
        places.add(new Place(R.drawable.abu_sambil,"Abu Simbel", "Aswan", "abu sambil","geo:22.3372319,31.625799?z=15","Aswan"));
        places.add(new Place(R.drawable.wadi_almuluk,"The Valley of the Kings", "Luxor", "wadi almuluk","geo:25.7401643,32.601411?z=15","Luxor, New Valley"));
        places.add(new Place(R.drawable.maebad_alkurnak,"Karnak Temple", "Luxor", "maebad alkurnak","geo:25.7188346,32.6572703?z=15","El-Karnak, Luxor, Luxor"));
        places.add(new Place(R.drawable.maebad_fila,"Philae Temple", "Aswan", "maebad fila","geo:24.0251757,32.8824542?z=17","Aswan"));
        places.add(new Place(R.drawable.wahat_siuwa,"Siwa Oasis", "Matrouh", "wahat siuwa‎‎","geo:29.2059451,25.4567969?z=12","Siwa Oasis, Qesm Siwah, Matrouh"));
        places.add(new Place(R.drawable.dayr_sanat_katryn,"Saint Catherine's Monastery", "South Sinai", "dayr sanat katryn","geo:28.5559484,33.976048?z=15","Qesm Sharm Ash Sheikh, South Sinai"));
        places.add(new Place(R.drawable.jamie_alazhar,"Al-Azhar Mosque", "Cairo", "jamie al'azhar","geo:30.045688,31.2626851?z=15","El-Darb El-Ahmar, Cairo"));
        places.add(new Place(R.drawable.dar_aluwbara_almsry,"Cairo Opera House", "Cairo", "dar al'uwbara almsry","geo:30.0424866,31.2244568?z=15","Opera Land، EL GEZIRAH، Zamalek, Cairo"));
        places.add(new Place(R.drawable.qaleatan_salah_aldiyn,"Cairo Citadel", "Cairo", "qaleatan salah aldiyn","geo:30.0298604,31.2611055?z=15","Al Abageyah, Qesm Al Khalifah، Cairo"));
        places.add(new Place(R.drawable.qasr_albarun,"Baron Palace", "Cairo", "qasr albarun","geo:30.0867134,31.330259?z=15","El-Orouba, El-Montaza, Heliopolis, Cairo"));
        places.add(new Place(R.drawable.maktabat_alaskndry,"Library of Alexandria", "Alexandria", "maktabat alaskndry","geo:31.2088705,29.9092012?z=15","Al Azaritah WA Ash Shatebi, Qesm Bab Sharqi, Alexandria"));
        places.add(new Place(R.drawable.qaleat_qaytbay,"Citadel of Qaitbay", "Alexandria", "qaleat qaytbay","geo:31.214011,29.8856383?z=15","As Sayalah Sharq, Qesm Al Gomrok, Alexandria"));


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
