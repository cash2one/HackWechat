package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.l;

public class MessageEventParcelable implements SafeParcelable, l {
    public static final Creator<MessageEventParcelable> CREATOR = new aa();
    final String aYx;
    final byte[] bdg;
    final int beG;
    final String beo;
    final int mVersionCode;

    MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.mVersionCode = i;
        this.beG = i2;
        this.beo = str;
        this.bdg = bArr;
        this.aYx = str2;
    }

    public int describeContents() {
        return 0;
    }

    public final byte[] getData() {
        return this.bdg;
    }

    public final String getPath() {
        return this.beo;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.beG + "," + this.beo + ", size=" + (this.bdg == null ? "null" : Integer.valueOf(this.bdg.length)) + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        aa.a(this, parcel);
    }
}
