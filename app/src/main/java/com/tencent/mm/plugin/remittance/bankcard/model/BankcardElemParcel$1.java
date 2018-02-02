package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class BankcardElemParcel$1 implements Creator<BankcardElemParcel> {
    BankcardElemParcel$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BankcardElemParcel(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new BankcardElemParcel[i];
    }
}
