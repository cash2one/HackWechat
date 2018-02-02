package com.google.android.exoplayer2;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Format$1 implements Creator<Format> {
    Format$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Format(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Format[i];
    }
}
