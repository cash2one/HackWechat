package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;

class DrmInitData$SchemeData$1 implements Creator<SchemeData> {
    DrmInitData$SchemeData$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SchemeData(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SchemeData[i];
    }
}
