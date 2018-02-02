package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameTabData$TabItem implements Parcelable {
    public static final Creator<GameTabData$TabItem> CREATOR = new 1();
    public int fFj;
    public String jumpUrl;
    public String nbh;
    public String nei;
    public boolean nej;
    public boolean nek;
    public int nel;
    public int nem;
    public String nen;
    public String neo;
    public String nep;
    public boolean neq;
    public int ner;
    public String title;

    public GameTabData$TabItem(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.nei = parcel.readString();
        this.title = parcel.readString();
        this.jumpUrl = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.nej = z;
        this.nek = parcel.readByte() != (byte) 0;
        this.nel = parcel.readInt();
        this.nem = parcel.readInt();
        this.nen = parcel.readString();
        this.neo = parcel.readString();
        this.nep = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.neq = z2;
        this.fFj = parcel.readInt();
        this.ner = parcel.readInt();
        this.nbh = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.nei);
        parcel.writeString(this.title);
        parcel.writeString(this.jumpUrl);
        parcel.writeByte((byte) (this.nej ? 1 : 0));
        if (this.nek) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.nel);
        parcel.writeInt(this.nem);
        parcel.writeString(this.nen);
        parcel.writeString(this.neo);
        parcel.writeString(this.nep);
        if (!this.neq) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.fFj);
        parcel.writeInt(this.ner);
        parcel.writeString(this.nbh);
    }
}
