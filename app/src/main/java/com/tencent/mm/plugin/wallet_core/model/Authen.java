package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bh;

public class Authen implements Parcelable {
    public static final Creator<Authen> CREATOR = new 1();
    public String country;
    public int fDt;
    public String fWi;
    public String fWp;
    public String fWq;
    public String hxu;
    public String ilY;
    public String nBO;
    public String oZA;
    public String oZz;
    public PayInfo pCn = new PayInfo();
    public String sBQ;
    public String sIF;
    public String sKA;
    public String sKB;
    public String sKC;
    public String sKD;
    public String sKE;
    public String sKF;
    public String sKG;
    public String sKH;
    public String sKI;
    public int sKr = 0;
    public String sKs;
    public String sKt;
    public String sKu;
    public int sKv;
    public String sKw;
    public String sKx;
    public String sKy;
    public String sKz;
    public String token;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fDt);
        parcel.writeString(bh.az(this.sKs, ""));
        parcel.writeString(bh.az(this.oZz, ""));
        parcel.writeString(bh.az(this.oZA, ""));
        parcel.writeString(bh.az(this.sKt, ""));
        parcel.writeString(bh.az(this.sKu, ""));
        parcel.writeInt(this.sKv);
        parcel.writeString(bh.az(this.sIF, ""));
        parcel.writeString(bh.az(this.sKw, ""));
        parcel.writeString(bh.az(this.sKx, ""));
        parcel.writeString(bh.az(this.sKy, ""));
        parcel.writeString(bh.az(this.token, ""));
        parcel.writeString(bh.az(this.sKB, ""));
        parcel.writeString(bh.az(this.sKC, ""));
        parcel.writeString(bh.az(this.country, ""));
        parcel.writeString(bh.az(this.fWp, ""));
        parcel.writeString(bh.az(this.fWq, ""));
        parcel.writeString(bh.az(this.hxu, ""));
        parcel.writeString(bh.az(this.nBO, ""));
        parcel.writeString(bh.az(this.ilY, ""));
        parcel.writeString(bh.az(this.fWi, ""));
        parcel.writeString(bh.az(this.sBQ, ""));
        parcel.writeString(bh.az(this.sKD, ""));
        parcel.writeString(bh.az(this.sKE, ""));
        parcel.writeString(bh.az(this.sKA, ""));
        parcel.writeString(bh.az(this.sKF, ""));
        parcel.writeString(bh.az(this.sKG, ""));
        parcel.writeString(bh.az(this.sKH, ""));
        parcel.writeString(bh.az(this.sKI, ""));
    }

    public Authen(Parcel parcel) {
        this.fDt = parcel.readInt();
        this.sKs = parcel.readString();
        this.oZz = parcel.readString();
        this.oZA = parcel.readString();
        this.sKt = parcel.readString();
        this.sKu = parcel.readString();
        this.sKv = parcel.readInt();
        this.sIF = parcel.readString();
        this.sKw = parcel.readString();
        this.sKx = parcel.readString();
        this.sKy = parcel.readString();
        this.token = parcel.readString();
        this.sKB = parcel.readString();
        this.sKC = parcel.readString();
        this.country = parcel.readString();
        this.fWp = parcel.readString();
        this.fWq = parcel.readString();
        this.hxu = parcel.readString();
        this.nBO = parcel.readString();
        this.ilY = parcel.readString();
        this.fWi = parcel.readString();
        this.sBQ = parcel.readString();
        this.sKD = parcel.readString();
        this.sKE = parcel.readString();
        this.sKA = parcel.readString();
        this.sKF = parcel.readString();
        this.sKG = parcel.readString();
        this.sKH = parcel.readString();
        this.sKI = parcel.readString();
    }
}
