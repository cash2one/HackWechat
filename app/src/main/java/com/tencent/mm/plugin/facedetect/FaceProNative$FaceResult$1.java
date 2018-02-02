package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;

class FaceProNative$FaceResult$1 implements Creator<FaceResult> {
    FaceProNative$FaceResult$1() {
    }

    public final FaceResult createFromParcel(Parcel parcel) {
        return new FaceResult(parcel);
    }

    public final FaceResult[] newArray(int i) {
        return new FaceResult[i];
    }
}
