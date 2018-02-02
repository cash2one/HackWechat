package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR = new g();
    final String aPA;
    final int aPB;
    final List<String> aPC;
    final String aPD;
    int aPE;
    final String aPF;
    final String aPG;
    final float aPH;
    final long aPp;
    int aPq;
    final long aPx;
    private long aPz;
    final int mVersionCode;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f) {
        this.mVersionCode = i;
        this.aPp = j;
        this.aPq = i2;
        this.aPA = str;
        this.aPF = str3;
        this.aPB = i3;
        this.aPz = -1;
        this.aPC = list;
        this.aPD = str2;
        this.aPx = j2;
        this.aPE = i4;
        this.aPG = str4;
        this.aPH = f;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
