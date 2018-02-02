package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.RecommendTinyAppInfo;

class Orders$RecommendTinyAppInfo$1 implements Creator<RecommendTinyAppInfo> {
    Orders$RecommendTinyAppInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new RecommendTinyAppInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new RecommendTinyAppInfo[i];
    }
}
