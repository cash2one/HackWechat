package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import d.a.a.b;

public class Orders$Promotions implements Parcelable {
    public static final Creator<Orders$Promotions> CREATOR = new 1();
    public String name;
    public String paA;
    public String peY;
    public long sIr;
    public int sNu;
    public int sNv;
    public long sNw;
    public String sNx;
    public int sOA;
    public int sOB;
    public int sOC;
    public String sOD;
    public String sOE;
    public String sOF;
    public int sOG;
    public String sOH;
    public String sOI;
    public b sOJ;
    public String title;
    public int type;
    public String url;

    public Orders$Promotions(Parcel parcel) {
        this.type = parcel.readInt();
        this.peY = parcel.readString();
        this.name = parcel.readString();
        this.sNx = parcel.readString();
        this.url = parcel.readString();
        this.paA = parcel.readString();
        this.title = parcel.readString();
        this.sOA = parcel.readInt();
        this.sIr = parcel.readLong();
        this.sOB = parcel.readInt();
        this.sOC = parcel.readInt();
        this.sNu = parcel.readInt();
        this.sNv = parcel.readInt();
        this.sOD = parcel.readString();
        this.sOE = parcel.readString();
        this.sOF = parcel.readString();
        this.sNw = parcel.readLong();
        this.sOG = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.peY);
        parcel.writeString(this.name);
        parcel.writeString(this.sNx);
        parcel.writeString(this.url);
        parcel.writeString(this.paA);
        parcel.writeString(this.title);
        parcel.writeInt(this.sOA);
        parcel.writeLong(this.sIr);
        parcel.writeInt(this.sOB);
        parcel.writeInt(this.sOC);
        parcel.writeInt(this.sNu);
        parcel.writeInt(this.sNv);
        parcel.writeString(this.sOD);
        parcel.writeString(this.sOE);
        parcel.writeString(this.sOF);
        parcel.writeLong(this.sNw);
        parcel.writeInt(this.sOG);
    }
}
