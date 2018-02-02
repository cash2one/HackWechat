package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR = new a();
    final long aPp;
    int aPq;
    final String aPr;
    final String aPs;
    final String aPt;
    final String aPu;
    final String aPv;
    final String aPw;
    final long aPx;
    final long aPy;
    private long aPz;
    final int mVersionCode;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.aPp = j;
        this.aPq = i2;
        this.aPr = str;
        this.aPs = str2;
        this.aPt = str3;
        this.aPu = str4;
        this.aPz = -1;
        this.aPv = str5;
        this.aPw = str6;
        this.aPx = j2;
        this.aPy = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
