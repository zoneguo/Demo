package com.zone.androidtest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by p_zoneguo on 2018/3/23.
 */

public class Window implements Parcelable {
    private String title;

    public Window() {

    }

    protected Window(Parcel in) {
        this.title = in.readString();
    }

    public static final Creator<Window> CREATOR = new Creator<Window>() {
        @Override
        public Window createFromParcel(Parcel in) {
            return new Window(in);
        }

        @Override
        public Window[] newArray(int size) {
            return new Window[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
    }

    public void readFromParcel(Parcel parcel) {
        title = parcel.readString();
    }
}
