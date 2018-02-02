package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class PeriodicTask$1 implements Creator<PeriodicTask> {
    PeriodicTask$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PeriodicTask(parcel, (byte) 0);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PeriodicTask[i];
    }
}
