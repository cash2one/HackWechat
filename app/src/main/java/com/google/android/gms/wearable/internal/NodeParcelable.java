package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.m;

public class NodeParcelable implements SafeParcelable, m {
    public static final Creator<NodeParcelable> CREATOR = new ad();
    final String aEO;
    final String baH;
    final int beH;
    final boolean beI;
    final int mVersionCode;

    NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.mVersionCode = i;
        this.aEO = str;
        this.baH = str2;
        this.beH = i2;
        this.beI = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof NodeParcelable) ? false : ((NodeParcelable) obj).aEO.equals(this.aEO);
    }

    public final String getId() {
        return this.aEO;
    }

    public int hashCode() {
        return this.aEO.hashCode();
    }

    public String toString() {
        return "Node{" + this.baH + ", id=" + this.aEO + ", hops=" + this.beH + ", isNearby=" + this.beI + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.a(this, parcel);
    }
}
