package com.wrstech.spotour;

/**
 * Created by wilso on 4/1/2018.
 */

public class Place {

    private String mPlaceTitle;
    private String mInfo;
    private int mPicture;

    public String getPlaceTitle() {
        return mPlaceTitle;
    }

    public String getInfo() {
        return mInfo;
    }

    public int getPicture() {
        return mPicture;
    }

    public Place(String placeTitle, String info, int picture){
        mPlaceTitle = placeTitle;
        mInfo = info;
        mPicture = picture;
    }
}
