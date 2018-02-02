package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.nd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;

public class SnsAdClick implements Parcelable {
    public static final Creator<SnsAdClick> CREATOR = new 1();
    public int hOA;
    public int hOB;
    public long hOC;
    public long hOD;
    public String hOt;
    public long hOu;
    public String hOv;
    public String hOw;
    public int hOx;
    public long hOy;
    public int hOz;
    public int scene;

    public SnsAdClick() {
        this.hOt = "";
        this.scene = 0;
        this.hOu = 0;
        this.hOv = "";
        this.hOw = "";
        this.hOx = 0;
        this.hOy = 0;
        this.hOz = 0;
        this.hOA = 0;
        this.hOB = 0;
        this.hOC = 0;
        this.hOD = 0;
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2) {
        this.hOt = "";
        this.scene = 0;
        this.hOu = 0;
        this.hOv = "";
        this.hOw = "";
        this.hOx = 0;
        this.hOy = 0;
        this.hOz = 0;
        this.hOA = 0;
        this.hOB = 0;
        this.hOC = 0;
        this.hOD = 0;
        this.hOt = str;
        this.scene = i;
        this.hOu = j;
        this.hOv = str2;
        this.hOz = i2;
        this.hOA = 1;
        this.hOy = System.currentTimeMillis();
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2, byte b) {
        this.hOt = "";
        this.scene = 0;
        this.hOu = 0;
        this.hOv = "";
        this.hOw = "";
        this.hOx = 0;
        this.hOy = 0;
        this.hOz = 0;
        this.hOA = 0;
        this.hOB = 0;
        this.hOC = 0;
        this.hOD = 0;
        this.hOt = str;
        this.scene = i;
        this.hOu = j;
        this.hOv = str2;
        this.hOz = i2;
        this.hOA = 0;
        this.hOy = System.currentTimeMillis();
    }

    public SnsAdClick(String str, String str2, int i, int i2) {
        this.hOt = "";
        this.scene = 0;
        this.hOu = 0;
        this.hOv = "";
        this.hOw = "";
        this.hOx = 0;
        this.hOy = 0;
        this.hOz = 0;
        this.hOA = 0;
        this.hOB = 0;
        this.hOC = 0;
        this.hOD = 0;
        this.hOt = "";
        this.scene = 7;
        this.hOw = str;
        this.hOv = str2;
        this.hOz = i;
        this.hOA = 0;
        this.hOB = i2;
        this.hOy = System.currentTimeMillis();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hOt);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.hOx);
        parcel.writeLong(this.hOu);
        parcel.writeString(bh.az(this.hOv, ""));
        parcel.writeLong(this.hOy);
        parcel.writeInt(this.hOA);
        parcel.writeInt(this.hOz);
        parcel.writeInt(this.hOB);
        parcel.writeString(this.hOw);
        parcel.writeLong(this.hOD);
    }

    public final void it(int i) {
        Ss();
        b ndVar = new nd();
        this.hOx = i;
        ndVar.fFd.fFe = this;
        a.xef.m(ndVar);
    }

    public final void Ss() {
        if (this.hOC > 0) {
            this.hOD += bh.bA(this.hOC);
            this.hOC = 0;
        }
    }
}
