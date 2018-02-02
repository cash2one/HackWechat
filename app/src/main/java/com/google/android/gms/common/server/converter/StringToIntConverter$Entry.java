package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class StringToIntConverter$Entry implements SafeParcelable {
    public static final c CREATOR = new c();
    final String aOU;
    final int aOV;
    final int versionCode;

    StringToIntConverter$Entry(int i, String str, int i2) {
        this.versionCode = i;
        this.aOU = str;
        this.aOV = i2;
    }

    StringToIntConverter$Entry(String str, int i) {
        this.versionCode = 1;
        this.aOU = str;
        this.aOV = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel);
    }
}
