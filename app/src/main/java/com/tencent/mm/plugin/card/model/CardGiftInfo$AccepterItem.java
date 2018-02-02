package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardGiftInfo$AccepterItem implements Parcelable {
    public static final Creator<CardGiftInfo$AccepterItem> CREATOR = new Creator<CardGiftInfo$AccepterItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CardGiftInfo$AccepterItem(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardGiftInfo$AccepterItem[i];
        }
    };
    public String kKO;
    public String kKP;
    public String kKQ;
    public String kKR;

    private CardGiftInfo$AccepterItem(Parcel parcel) {
        this.kKO = parcel.readString();
        this.kKP = parcel.readString();
        this.kKQ = parcel.readString();
        this.kKR = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.kKO);
        parcel.writeString(this.kKP);
        parcel.writeString(this.kKQ);
        parcel.writeString(this.kKR);
    }

    public int describeContents() {
        return 0;
    }
}
