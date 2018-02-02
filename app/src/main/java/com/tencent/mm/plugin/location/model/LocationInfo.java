package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bh;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new 1();
    public String fDu;
    public String nQA;
    String nQB;
    public int nQC;
    public String nQw;
    public double nQx;
    public double nQy;
    public String nQz;
    public int zoom;

    public LocationInfo() {
        this.nQw = "";
        this.nQx = -85.0d;
        this.nQy = -1000.0d;
        this.nQz = "";
        this.nQA = "zh-cn";
        this.nQB = "";
        this.nQC = 0;
    }

    public LocationInfo(byte b) {
        this.nQw = "";
        this.nQx = -85.0d;
        this.nQy = -1000.0d;
        this.nQz = "";
        this.nQA = "zh-cn";
        this.nQB = "";
        this.nQC = 0;
        this.nQw = toString() + " " + System.nanoTime();
        this.zoom = d.gm(false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nQw);
        parcel.writeDouble(this.nQx);
        parcel.writeDouble(this.nQy);
        parcel.writeInt(this.zoom);
        parcel.writeString(this.nQz);
        parcel.writeString(this.nQA);
        parcel.writeString(this.fDu);
        parcel.writeString(this.nQB);
        parcel.writeInt(this.nQC);
    }

    public final boolean aVk() {
        if (this.nQx == -85.0d || this.nQy == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean aVl() {
        if (bh.ov(this.nQz) && bh.ov(this.fDu)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.nQx + " " + this.nQy + " " + this.nQz + " " + this.fDu + "  " + this.nQw;
    }

    public int describeContents() {
        return 0;
    }
}
