package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new u();
    boolean aFq;
    final int aMe;
    final String bdj;
    final int bdk;
    final boolean bdl;
    String bdm;
    boolean bdn;
    String bdo;
    final String mName;
    final int mVersionCode;

    ConnectionConfiguration(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.mVersionCode = i;
        this.mName = str;
        this.bdj = str2;
        this.aMe = i2;
        this.bdk = i3;
        this.bdl = z;
        this.aFq = z2;
        this.bdm = str3;
        this.bdn = z3;
        this.bdo = str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return v.b(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && v.b(this.mName, connectionConfiguration.mName) && v.b(this.bdj, connectionConfiguration.bdj) && v.b(Integer.valueOf(this.aMe), Integer.valueOf(connectionConfiguration.aMe)) && v.b(Integer.valueOf(this.bdk), Integer.valueOf(connectionConfiguration.bdk)) && v.b(Boolean.valueOf(this.bdl), Boolean.valueOf(connectionConfiguration.bdl)) && v.b(Boolean.valueOf(this.bdn), Boolean.valueOf(connectionConfiguration.bdn));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), this.mName, this.bdj, Integer.valueOf(this.aMe), Integer.valueOf(this.bdk), Boolean.valueOf(this.bdl), Boolean.valueOf(this.bdn)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.bdj);
        stringBuilder.append(", mType=" + this.aMe);
        stringBuilder.append(", mRole=" + this.bdk);
        stringBuilder.append(", mEnabled=" + this.bdl);
        stringBuilder.append(", mIsConnected=" + this.aFq);
        stringBuilder.append(", mPeerNodeId=" + this.bdm);
        stringBuilder.append(", mBtlePriority=" + this.bdn);
        stringBuilder.append(", mNodeId=" + this.bdo);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        u.a(this, parcel);
    }
}
