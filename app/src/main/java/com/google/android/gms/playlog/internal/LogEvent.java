package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final a CREATOR = new a();
    public final long bau;
    public final long bav;
    public final byte[] baw;
    public final Bundle bax;
    public final String tag;
    public final int versionCode;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.bau = j;
        this.bav = j2;
        this.tag = str;
        this.baw = bArr;
        this.bax = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.tag).append(",");
        stringBuilder.append("eventTime=").append(this.bau).append(",");
        stringBuilder.append("eventUptime=").append(this.bav).append(",");
        if (!(this.bax == null || this.bax.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.bax.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.bax.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
