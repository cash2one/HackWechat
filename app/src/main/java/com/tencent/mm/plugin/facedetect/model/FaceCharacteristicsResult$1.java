package com.tencent.mm.plugin.facedetect.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class FaceCharacteristicsResult$1 implements Creator<FaceCharacteristicsResult> {
    FaceCharacteristicsResult$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new FaceCharacteristicsResult(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new FaceCharacteristicsResult[i];
    }
}
