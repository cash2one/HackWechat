package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class MCacheItem$1 implements Creator<MCacheItem> {
    MCacheItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new MCacheItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MCacheItem[i];
    }
}
