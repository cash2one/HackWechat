package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameTabData$StatusBar implements Parcelable {
    public static final Creator<GameTabData$StatusBar> CREATOR = new Creator<GameTabData$StatusBar>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GameTabData$StatusBar(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameTabData$StatusBar[i];
        }
    };
    public int color = 0;
    public String neh = null;

    public GameTabData$StatusBar(Parcel parcel) {
        this.neh = parcel.readString();
        this.color = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.neh);
        parcel.writeInt(this.color);
    }
}
