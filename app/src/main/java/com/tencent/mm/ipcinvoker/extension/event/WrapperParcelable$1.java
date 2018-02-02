package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable$1 implements Creator<WrapperParcelable> {
    WrapperParcelable$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        WrapperParcelable wrapperParcelable = new WrapperParcelable((byte) 0);
        if (parcel.readInt() == 1) {
            wrapperParcelable.gMY = c.a(parcel.readString(), parcel);
        }
        return wrapperParcelable;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WrapperParcelable[i];
    }
}
