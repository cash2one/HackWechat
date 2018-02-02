package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyRequest implements SafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new b();
    public static final int aJf = 0;
    public static final int aJg = 1;
    public static final int aJh = 2;
    public static final int aJi = 3;
    public static final int aJj = 4;
    public static final int aJk = 5;
    public static final int aJl = 6;
    public static final int aJm = 7;
    public static final int aJn = 7;
    public final long aJe;
    public final int aJo;
    Bundle aJp;
    public final byte[] body;
    public final String url;
    final int versionCode;

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.aJo = i2;
        this.aJe = j;
        this.body = bArr;
        this.aJp = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.aJo + " ]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
