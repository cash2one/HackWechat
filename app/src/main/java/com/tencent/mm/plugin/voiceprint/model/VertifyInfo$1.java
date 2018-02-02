package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class VertifyInfo$1 implements Creator<VertifyInfo> {
    VertifyInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = true;
        VertifyInfo vertifyInfo = new VertifyInfo();
        vertifyInfo.sgT = parcel.readInt();
        vertifyInfo.sgU = parcel.readInt();
        vertifyInfo.sgV = parcel.readInt();
        vertifyInfo.sgK = parcel.readInt();
        vertifyInfo.jUJ = parcel.readString();
        vertifyInfo.sgD = parcel.readString();
        vertifyInfo.mFileName = parcel.readString();
        vertifyInfo.sgW = parcel.readInt() > 0;
        if (parcel.readInt() <= 0) {
            z = false;
        }
        vertifyInfo.sgX = z;
        vertifyInfo.sgK = vertifyInfo.sgT;
        return vertifyInfo;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new VertifyInfo[i];
    }
}
