package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.os.Parcel;
import android.os.Parcelable;

public class NetScenePayUElementQuery$PayUBankcardElement implements Parcelable {
    public String cardType = "";
    public String fzP = "";
    public String pax = "";
    public String tbA = "";
    public String tbB = "";

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tbA);
        parcel.writeString(this.pax);
        parcel.writeString(this.tbB);
        parcel.writeString(this.cardType);
        parcel.writeString(this.fzP);
    }
}
