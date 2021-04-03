package com.example.hello_geekbrains.bussines_logic;

import android.os.Parcel;
import android.os.Parcelable;

public class Theme implements Parcelable {
    private int chosenTheme;
    public Theme(int chosenTheme){
        this.chosenTheme = chosenTheme;
    }

    public int getChosenTheme() {
        return chosenTheme;
    }

    public void setChosenTheme(int chosenTheme) {
        this.chosenTheme = chosenTheme;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
