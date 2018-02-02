package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Creator<ColorInfo> CREATOR = new Creator<ColorInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ColorInfo[0];
        }
    };
    public final int aCO;
    public final int aCP;
    public final int aCQ;
    public final byte[] aCR;
    private int aen;

    ColorInfo(Parcel parcel) {
        this.aCO = parcel.readInt();
        this.aCP = parcel.readInt();
        this.aCQ = parcel.readInt();
        this.aCR = (parcel.readInt() != 0 ? 1 : null) != null ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColorInfo colorInfo = (ColorInfo) obj;
        if (this.aCO == colorInfo.aCO && this.aCP == colorInfo.aCP && this.aCQ == colorInfo.aCQ && Arrays.equals(this.aCR, colorInfo.aCR)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "ColorInfo(" + this.aCO + ", " + this.aCP + ", " + this.aCQ + ", " + (this.aCR != null) + ")";
    }

    public final int hashCode() {
        if (this.aen == 0) {
            this.aen = ((((((this.aCO + 527) * 31) + this.aCP) * 31) + this.aCQ) * 31) + Arrays.hashCode(this.aCR);
        }
        return this.aen;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.aCO);
        parcel.writeInt(this.aCP);
        parcel.writeInt(this.aCQ);
        parcel.writeInt(this.aCR != null ? 1 : 0);
        if (this.aCR != null) {
            parcel.writeByteArray(this.aCR);
        }
    }
}
