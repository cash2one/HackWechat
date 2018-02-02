package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class GameTabData$1 implements Creator<GameTabData> {
    GameTabData$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GameTabData(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GameTabData[i];
    }
}
