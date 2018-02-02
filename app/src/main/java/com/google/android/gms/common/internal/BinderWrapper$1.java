package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BinderWrapper$1 implements Creator<BinderWrapper> {
    BinderWrapper$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (byte) 0);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new BinderWrapper[i];
    }
}
