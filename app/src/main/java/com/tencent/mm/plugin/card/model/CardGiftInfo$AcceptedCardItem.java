package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardGiftInfo$AcceptedCardItem implements Parcelable {
    public static final Creator<CardGiftInfo$AcceptedCardItem> CREATOR = new 1();
    public String kKO;
    public String kKP;

    private CardGiftInfo$AcceptedCardItem(Parcel parcel) {
        this.kKO = parcel.readString();
        this.kKP = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kKO);
        parcel.writeString(this.kKP);
    }

    public int describeContents() {
        return 0;
    }
}
