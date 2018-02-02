package com.tencent.mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;

class MallOrderDetailObject$HelpCenter$1 implements Creator<HelpCenter> {
    MallOrderDetailObject$HelpCenter$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new HelpCenter(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new HelpCenter[i];
    }
}
