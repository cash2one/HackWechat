package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class Orders$DeductInfo implements Parcelable {
    public static final Creator<Orders$DeductInfo> CREATOR = new 1();
    public String desc;
    public String kLA;
    public int sFs;
    public String sFt;
    public int sGa;
    public String sOv;
    public List<Orders$DeductShowInfo> sOw = new ArrayList();
    public int sOx;
    public String sOy;
    public String title;

    public Orders$DeductInfo(Parcel parcel) {
        this.title = parcel.readString();
        this.desc = parcel.readString();
        this.sGa = parcel.readInt();
        this.sOv = parcel.readString();
        this.sOx = parcel.readInt();
        parcel.readTypedList(this.sOw, Orders$DeductShowInfo.CREATOR);
        this.sFs = parcel.readInt();
        this.kLA = parcel.readString();
        this.sFt = parcel.readString();
        this.sOy = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.title);
        parcel.writeString(this.desc);
        parcel.writeInt(this.sGa);
        parcel.writeString(this.sOv);
        parcel.writeInt(this.sOx);
        parcel.writeTypedList(this.sOw);
        parcel.writeInt(this.sFs);
        parcel.writeString(this.kLA);
        parcel.writeString(this.sFt);
        parcel.writeString(this.sOy);
    }
}
