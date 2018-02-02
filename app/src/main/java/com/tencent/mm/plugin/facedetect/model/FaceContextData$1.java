package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class FaceContextData$1 implements Creator<FaceContextData> {
    FaceContextData$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FaceContextData(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FaceContextData[i];
    }
}
