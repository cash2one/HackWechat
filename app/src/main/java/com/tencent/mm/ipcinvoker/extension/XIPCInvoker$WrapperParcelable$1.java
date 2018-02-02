package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker.WrapperParcelable;

class XIPCInvoker$WrapperParcelable$1 implements Creator<WrapperParcelable> {
    XIPCInvoker$WrapperParcelable$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        WrapperParcelable wrapperParcelable = new WrapperParcelable((byte) 0);
        wrapperParcelable.gNa = parcel.readString();
        if (parcel.readInt() == 1) {
            wrapperParcelable.gMY = c.a(parcel.readString(), parcel);
        }
        return wrapperParcelable;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WrapperParcelable[i];
    }
}
