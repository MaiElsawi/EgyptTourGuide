package com.app.mai.egypttourguide;

import android.app.Application;

public class Place extends Application {
    private int imageView;
    private String placeName;
    private String placeLocation;
    private String howToSpeakItLikeArabic;
    private String mapLocation;
    private String locationAddress;


    public Place(int imageView, String placeName, String placeLocation, String howToSpeakItLikeArabic, String mapLocation, String locationAddress) {
        this.imageView = imageView;
        this.placeName = placeName;
        this.placeLocation = placeLocation;
        this.howToSpeakItLikeArabic = howToSpeakItLikeArabic;
        this.mapLocation = mapLocation;
        this.locationAddress = locationAddress;
    }

    public int getImageView() {
        return imageView;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceLocation() {
        return placeLocation;
    }

    public String getHowToSpeakItLikeArabic() {
        return howToSpeakItLikeArabic;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public String getLocationAddress() {
        return locationAddress;
    }
}


