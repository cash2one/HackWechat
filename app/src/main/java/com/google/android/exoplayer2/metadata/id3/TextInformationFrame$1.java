package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class TextInformationFrame$1 implements Creator<TextInformationFrame> {
    TextInformationFrame$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new TextInformationFrame(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TextInformationFrame[i];
    }
}
