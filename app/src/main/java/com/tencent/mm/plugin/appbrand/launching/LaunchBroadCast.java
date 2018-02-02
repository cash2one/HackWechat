package com.tencent.mm.plugin.appbrand.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.ipc.d;

public final class LaunchBroadCast implements Parcelable {
    public static final Creator<LaunchBroadCast> CREATOR = new 1();
    public String appId;
    public boolean fJW;
    public int iKd;
    public int jxz;
    public String username;

    static void a(String str, int i, int i2, boolean z) {
        Parcelable launchBroadCast = new LaunchBroadCast();
        launchBroadCast.username = null;
        launchBroadCast.appId = str;
        launchBroadCast.iKd = i;
        launchBroadCast.jxz = i2;
        launchBroadCast.fJW = z;
        d.a(launchBroadCast);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeInt(this.iKd);
        parcel.writeInt(this.jxz);
        parcel.writeByte(this.fJW ? (byte) 1 : (byte) 0);
    }

    private LaunchBroadCast() {
    }

    private LaunchBroadCast(Parcel parcel) {
        this.username = parcel.readString();
        this.appId = parcel.readString();
        this.iKd = parcel.readInt();
        this.jxz = parcel.readInt();
        this.fJW = parcel.readByte() != (byte) 0;
    }
}
