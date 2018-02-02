package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.sw;

public class EnterTimeParcel implements Parcelable {
    public static final Creator<EnterTimeParcel> CREATOR = new 1();
    public String hbM;
    public int pHA;
    public int pHx;
    public String pHy;
    public String pHz;

    public EnterTimeParcel(sw swVar) {
        this.pHx = swVar.pHx;
        this.pHy = swVar.pHy;
        this.pHz = swVar.pHz;
        this.pHA = swVar.pHA;
        this.hbM = swVar.hbM;
    }

    public EnterTimeParcel(Parcel parcel) {
        this.pHx = parcel.readInt();
        this.pHy = parcel.readString();
        this.pHz = parcel.readString();
        this.pHA = parcel.readInt();
        this.hbM = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.pHx);
        parcel.writeString(this.pHy);
        parcel.writeString(this.pHz);
        parcel.writeInt(this.pHA);
        parcel.writeString(this.hbM);
    }
}
