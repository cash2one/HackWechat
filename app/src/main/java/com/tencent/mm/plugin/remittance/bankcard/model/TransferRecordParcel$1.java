package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class TransferRecordParcel$1 implements Creator<TransferRecordParcel> {
    TransferRecordParcel$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new TransferRecordParcel(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TransferRecordParcel[i];
    }
}
