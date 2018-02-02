package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Profession implements Parcelable {
    public static final Creator<Profession> CREATOR = new 1();
    public String sKd;
    public int sKe;

    public Profession(String str, int i) {
        this.sKd = str;
        this.sKe = i;
    }

    protected Profession(Parcel parcel) {
        this.sKd = parcel.readString();
        this.sKe = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sKd);
        parcel.writeInt(this.sKe);
    }
}
