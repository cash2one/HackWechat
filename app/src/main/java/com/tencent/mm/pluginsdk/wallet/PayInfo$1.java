package com.tencent.mm.pluginsdk.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class PayInfo$1 implements Creator<PayInfo> {
    PayInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new PayInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new PayInfo[i];
    }
}
