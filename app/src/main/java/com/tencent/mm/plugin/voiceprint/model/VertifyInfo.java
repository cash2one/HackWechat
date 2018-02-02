package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;

public class VertifyInfo implements Parcelable {
    public static final Creator<VertifyInfo> CREATOR = new 1();
    public String jUJ = "";
    public String mFileName = "";
    public String sgD = "";
    public int sgK = 0;
    public String sgP = "";
    public int sgT;
    public int sgU;
    public int sgV = 0;
    public boolean sgW = false;
    public boolean sgX = false;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.sgT);
        parcel.writeInt(this.sgU);
        parcel.writeInt(this.sgV);
        parcel.writeInt(this.sgK);
        parcel.writeString(bh.az(this.jUJ, ""));
        parcel.writeString(bh.az(this.sgD, ""));
        parcel.writeString(bh.az(this.mFileName, ""));
        if (this.sgW) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.sgX) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
