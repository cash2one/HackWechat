package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.g;

public class DataItemAssetParcelable implements SafeParcelable, g {
    public static final Creator<DataItemAssetParcelable> CREATOR = new b();
    final String aEO;
    final String aXw;
    final int mVersionCode;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.mVersionCode = i;
        this.aEO = str;
        this.aXw = str2;
    }

    public DataItemAssetParcelable(g gVar) {
        this.mVersionCode = 1;
        this.aEO = (String) w.ag(gVar.getId());
        this.aXw = (String) w.ag(gVar.rr());
    }

    public int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.aEO;
    }

    public final /* synthetic */ Object oy() {
        return this;
    }

    public final String rr() {
        return this.aXw;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.aEO == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.aEO);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.aXw);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
