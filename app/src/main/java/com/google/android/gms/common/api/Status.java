package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public final class Status implements g, SafeParcelable {
    public static final Creator<Status> CREATOR = new t();
    public static final Status aKq = new Status(0);
    public static final Status aKr = new Status(14);
    public static final Status aKs = new Status(8);
    public static final Status aKt = new Status(15);
    public static final Status aKu = new Status(16);
    public final int aJD;
    final PendingIntent aJE;
    public final String aKv;
    final int mVersionCode;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.aJD = i2;
        this.aKv = str;
        this.aJE = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(String str) {
        this(1, 8, str, null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.aJD == status.aJD && v.b(this.aKv, status.aKv) && v.b(this.aJE, status.aJE);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), Integer.valueOf(this.aJD), this.aKv, this.aJE});
    }

    public final boolean isSuccess() {
        return this.aJD <= 0;
    }

    public final Status og() {
        return this;
    }

    public final String toString() {
        return v.af(this).g("statusCode", this.aKv != null ? this.aKv : b.dg(this.aJD)).g("resolution", this.aJE).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        t.a(this, parcel, i);
    }
}
