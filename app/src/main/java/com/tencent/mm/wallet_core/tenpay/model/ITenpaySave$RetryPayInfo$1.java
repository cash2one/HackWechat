package com.tencent.mm.wallet_core.tenpay.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;

class ITenpaySave$RetryPayInfo$1 implements Creator<RetryPayInfo> {
    ITenpaySave$RetryPayInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RetryPayInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RetryPayInfo[i];
    }
}
