package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class Command$1 implements Creator<Command> {
    Command$1() {
    }

    @Deprecated
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Command(parcel);
    }

    @Deprecated
    public final /* synthetic */ Object[] newArray(int i) {
        return new Command[i];
    }
}
