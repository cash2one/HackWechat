package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public class a$a extends RuntimeException {
    public a$a(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }
}
