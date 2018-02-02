package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RepresentationKey implements Parcelable, Comparable<RepresentationKey> {
    public static final Creator<RepresentationKey> CREATOR = new 1();
    public final int arS;
    public final int asQ;
    public final int asR;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        RepresentationKey representationKey = (RepresentationKey) obj;
        int i = this.arS - representationKey.arS;
        if (i != 0) {
            return i;
        }
        i = this.asQ - representationKey.asQ;
        return i == 0 ? this.asR - representationKey.asR : i;
    }

    public RepresentationKey(int i, int i2, int i3) {
        this.arS = i;
        this.asQ = i2;
        this.asR = i3;
    }

    public final String toString() {
        return this.arS + "." + this.asQ + "." + this.asR;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.arS);
        parcel.writeInt(this.asQ);
        parcel.writeInt(this.asR);
    }
}
