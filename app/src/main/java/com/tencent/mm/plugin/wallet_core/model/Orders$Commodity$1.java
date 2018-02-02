package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;

class Orders$Commodity$1 implements Creator<Commodity> {
    Orders$Commodity$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Commodity(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Commodity[i];
    }
}
