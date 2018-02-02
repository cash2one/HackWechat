package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class ApicFrame$1 implements Creator<ApicFrame> {
    ApicFrame$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new ApicFrame(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new ApicFrame[i];
    }
}
