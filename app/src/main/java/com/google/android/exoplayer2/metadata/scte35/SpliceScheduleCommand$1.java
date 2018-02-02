package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SpliceScheduleCommand$1 implements Creator<SpliceScheduleCommand> {
    SpliceScheduleCommand$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SpliceScheduleCommand(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SpliceScheduleCommand[i];
    }
}
