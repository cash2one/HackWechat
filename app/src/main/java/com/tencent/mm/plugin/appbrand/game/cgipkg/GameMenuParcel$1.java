package com.tencent.mm.plugin.appbrand.game.cgipkg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class GameMenuParcel$1 implements Creator<GameMenuParcel> {
    GameMenuParcel$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GameMenuParcel(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GameMenuParcel[i];
    }
}
