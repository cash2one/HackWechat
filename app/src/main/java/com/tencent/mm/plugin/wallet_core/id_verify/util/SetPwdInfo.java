package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SetPwdInfo implements Parcelable {
    public static final Creator<SetPwdInfo> CREATOR = new 1();
    public String odv;
    public String odw = "";
    public String odx = "";
    public int sKq;

    protected SetPwdInfo(Parcel parcel) {
        this.sKq = parcel.readInt();
        this.odv = parcel.readString();
        this.odw = parcel.readString();
        this.odx = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sKq);
        parcel.writeString(this.odv);
        parcel.writeString(this.odw);
        parcel.writeString(this.odx);
    }

    public int describeContents() {
        return 0;
    }
}
