package com.app.mai.egypttourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    int placeImage;
    String placeName;
    String placeLocation;
    String howToSpeakItLikeArabic;
    String mapLocation;
    String locationAddress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        Toolbar mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(R.string.details);

//TODO how can i chane the title of tool bar to "Details"

        // set the back button and from manifests set the parent activity to return to
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get the current intent
        Intent intent = getIntent();
        //get the attached extras from the intent

        /*what we need to receive:
                @ int imageView,
                @ String placeName,
                @ String placeLocation,
                @ String howToSpeakItLikeArabic,
                @ String mapLocation
                        */
        placeImage = intent.getIntExtra("imageView", 1);
        placeName = intent.getStringExtra("placeName");
        placeLocation = intent.getStringExtra("placeLocation");
        howToSpeakItLikeArabic = intent.getStringExtra("howToSpeakItLikeArabic");
        mapLocation = intent.getStringExtra("mapLocation");
        locationAddress = intent.getStringExtra("locationAddress");


        // set place Image
        ImageView placeImageView = findViewById(R.id.place_image);
        placeImageView.setImageResource(placeImage);

        // set place Name
        TextView placeNameView = findViewById(R.id.place_name);
        placeNameView.setText(placeName);

        // set place Location
        TextView placeLocationView = findViewById(R.id.place_location);
        placeLocationView.setText(placeLocation);

        // set how To Speak It Like Arabic
        TextView howToSpeakItLikeArabicView = findViewById(R.id.how_to_speak_it_like_arabic);
        switch (howToSpeakItLikeArabic) {
            // in case the original name has no translation
            case "":
                TextView howToSpeakItLikeArabicViewTitle = findViewById(R.id.how_to_speak_it_like_arabic_title);
                howToSpeakItLikeArabicView.setVisibility(View.INVISIBLE);
                howToSpeakItLikeArabicViewTitle.setVisibility(View.INVISIBLE);
                break;
            default:
                howToSpeakItLikeArabicView.setText(howToSpeakItLikeArabic);
                break;
        }

        // set map Location
        TextView locationAddressView = findViewById(R.id.location_address);
        locationAddressView.setText(locationAddress);
    }

    public void intentGoogleMap(View v) {
        String mapLocationString = mapLocation;
        Uri mapIntentUri = Uri.parse(mapLocationString);
        Intent google_map = new Intent(Intent.ACTION_VIEW, mapIntentUri);
        google_map.setPackage("com.google.android.apps.maps");
        if (google_map.resolveActivity(getPackageManager()) != null) {
            startActivity(google_map);

//            **************************************************************************
//            String s = "geo:27.1770292,31.1493983?z=13";
//            // in case of select item from list you've call getActivity()
//            getActivity().getPackageManager();
//            Uri gmmIntentUri = Uri.parse(s);
//            Intent google_map = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//            google_map.setPackage("com.google.android.apps.maps");
//            if (google_map.resolveActivity(getContext().getPackageManager()) != null) {
//                startActivity(google_map);
//            }
        }
    }
}
