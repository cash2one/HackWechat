package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class EventMessage$1 implements Creator<EventMessage> {
    EventMessage$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new EventMessage(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new EventMessage[i];
    }
}
