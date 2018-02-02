package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class FavorPayInfo$1 implements Creator<FavorPayInfo> {
    FavorPayInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FavorPayInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FavorPayInfo[i];
    }
}
