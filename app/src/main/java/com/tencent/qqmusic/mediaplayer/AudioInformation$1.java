package com.tencent.qqmusic.mediaplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class AudioInformation$1 implements Creator<AudioInformation> {
    AudioInformation$1() {
    }

    public final AudioInformation createFromParcel(Parcel parcel) {
        return new AudioInformation(parcel);
    }

    public final AudioInformation[] newArray(int i) {
        return new AudioInformation[i];
    }
}
