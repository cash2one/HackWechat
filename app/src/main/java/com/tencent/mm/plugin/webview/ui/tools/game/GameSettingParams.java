package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameSettingParams implements Parcelable {
    public static final Creator<GameSettingParams> CREATOR = new 1();
    public String fxA;
    public String fxB;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fxA);
        parcel.writeString(this.fxB);
    }

    private GameSettingParams(Parcel parcel) {
        this.fxA = parcel.readString();
        this.fxB = parcel.readString();
    }
}
