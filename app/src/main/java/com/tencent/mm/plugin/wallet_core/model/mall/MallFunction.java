package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MallFunction implements Parcelable {
    public static final Creator<MallFunction> CREATOR = new 1();
    public String fII;
    public String fLC;
    public String nvp;
    public String olA;
    public String olB;
    public String pBK;
    public String sQr;
    public ArrayList<String> sQs;
    public MallNews sQt;
    public String sQu;
    public int sQv = 0;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallFunction(Parcel parcel) {
        this.pBK = parcel.readString();
        this.fII = parcel.readString();
        this.sQr = parcel.readString();
        this.olA = parcel.readString();
        this.olB = parcel.readString();
        this.fLC = parcel.readString();
        this.nvp = parcel.readString();
        this.sQs = new ArrayList();
        parcel.readStringList(this.sQs);
        this.sQt = (MallNews) parcel.readParcelable(MallNews.class.getClassLoader());
        this.type = parcel.readInt();
        this.sQu = parcel.readString();
        this.sQv = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pBK);
        parcel.writeString(this.fII);
        parcel.writeString(this.sQr);
        parcel.writeString(this.olA);
        parcel.writeString(this.olB);
        parcel.writeString(this.fLC);
        parcel.writeString(this.nvp);
        parcel.writeStringList(this.sQs);
        parcel.writeParcelable(this.sQt, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.sQu);
        parcel.writeInt(this.sQv);
    }
}
