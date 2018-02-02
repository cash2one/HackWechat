package com.tencent.mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;

public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new 1();
    public int accuracy;
    public int fBe;
    public String fBg;
    public float hxF;
    public float hxG;
    public String mac;

    public Location(float f, float f2, int i, int i2, String str, String str2) {
        this.hxF = f;
        this.hxG = f2;
        this.accuracy = i;
        this.fBe = i2;
        this.mac = str;
        this.fBg = str2;
    }

    public final boolean bYW() {
        if (this.hxF != -85.0f && this.hxG != -1000.0f) {
            return false;
        }
        x.d("MicroMsg.Radar.Location", "mac and cellId is null");
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.hxF);
        parcel.writeFloat(this.hxG);
        parcel.writeInt(this.accuracy);
        parcel.writeInt(this.fBe);
        parcel.writeString(this.mac);
        parcel.writeString(this.fBg);
    }
}
