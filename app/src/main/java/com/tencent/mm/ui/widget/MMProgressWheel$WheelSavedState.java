package com.tencent.mm.ui.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class MMProgressWheel$WheelSavedState extends BaseSavedState {
    public static final Creator<MMProgressWheel$WheelSavedState> CREATOR = new 1();
    float yaa;
    int zuC;
    int zuD;
    float zuH;
    boolean zuJ;
    float zuK;
    boolean zuL;
    int zut;
    int zuu;
    int zuv;
    boolean zuw;

    MMProgressWheel$WheelSavedState(Parcelable parcelable) {
        super(parcelable);
    }

    private MMProgressWheel$WheelSavedState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(parcel);
        this.yaa = parcel.readFloat();
        this.zuK = parcel.readFloat();
        this.zuL = parcel.readByte() != (byte) 0;
        this.zuH = parcel.readFloat();
        this.zuu = parcel.readInt();
        this.zuC = parcel.readInt();
        this.zuv = parcel.readInt();
        this.zuD = parcel.readInt();
        this.zut = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.zuJ = z;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.zuw = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.yaa);
        parcel.writeFloat(this.zuK);
        parcel.writeByte((byte) (this.zuL ? 1 : 0));
        parcel.writeFloat(this.zuH);
        parcel.writeInt(this.zuu);
        parcel.writeInt(this.zuC);
        parcel.writeInt(this.zuv);
        parcel.writeInt(this.zuD);
        parcel.writeInt(this.zut);
        if (this.zuJ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.zuw) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}
