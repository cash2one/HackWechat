package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.HCEEventLogic.HCEMMToAppBrandMessageEvent;

class HCEEventLogic$HCEMMToAppBrandMessageEvent$1 implements Creator<HCEMMToAppBrandMessageEvent> {
    HCEEventLogic$HCEMMToAppBrandMessageEvent$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new HCEMMToAppBrandMessageEvent(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new HCEMMToAppBrandMessageEvent[i];
    }
}
