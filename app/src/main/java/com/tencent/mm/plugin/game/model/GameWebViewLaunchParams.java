package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameWebViewLaunchParams implements Parcelable {
    public static final Creator<GameWebViewLaunchParams> CREATOR = new 1();
    public GameFloatLayerInfo nes;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.nes, i);
    }

    private GameWebViewLaunchParams(Parcel parcel) {
        this.nes = (GameFloatLayerInfo) parcel.readParcelable(GameFloatLayerInfo.class.getClassLoader());
    }
}
