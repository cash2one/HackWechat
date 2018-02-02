package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SnsAdClick$1 implements Creator<SnsAdClick> {
    SnsAdClick$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        SnsAdClick snsAdClick = new SnsAdClick();
        snsAdClick.hOt = parcel.readString();
        snsAdClick.scene = parcel.readInt();
        snsAdClick.hOx = parcel.readInt();
        snsAdClick.hOu = parcel.readLong();
        snsAdClick.hOv = parcel.readString();
        snsAdClick.hOy = parcel.readLong();
        snsAdClick.hOA = parcel.readInt();
        snsAdClick.hOz = parcel.readInt();
        snsAdClick.hOB = parcel.readInt();
        snsAdClick.hOw = parcel.readString();
        snsAdClick.hOD = parcel.readLong();
        return snsAdClick;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SnsAdClick[i];
    }
}
