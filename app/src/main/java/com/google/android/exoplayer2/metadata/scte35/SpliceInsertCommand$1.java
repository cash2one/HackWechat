package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class SpliceInsertCommand$1 implements Creator<SpliceInsertCommand> {
    SpliceInsertCommand$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SpliceInsertCommand(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SpliceInsertCommand[i];
    }
}
