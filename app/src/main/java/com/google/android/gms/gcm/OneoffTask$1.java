package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class OneoffTask$1 implements Creator<OneoffTask> {
    OneoffTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new OneoffTask(parcel, (byte) 0);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new OneoffTask[i];
    }
}
