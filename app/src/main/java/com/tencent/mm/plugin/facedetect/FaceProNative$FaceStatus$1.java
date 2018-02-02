package com.tencent.mm.plugin.facedetect;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceStatus;

class FaceProNative$FaceStatus$1 implements Creator<FaceStatus> {
    FaceProNative$FaceStatus$1() {
    }

    public final FaceStatus createFromParcel(Parcel parcel) {
        return new FaceStatus(parcel);
    }

    public final FaceStatus[] newArray(int i) {
        return new FaceStatus[i];
    }
}
