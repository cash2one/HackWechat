package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class RepresentationKey$1 implements Creator<RepresentationKey> {
    RepresentationKey$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RepresentationKey(parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RepresentationKey[i];
    }
}
