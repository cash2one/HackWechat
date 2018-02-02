package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.WxaWidgetContextImpl;

class WxaWidgetInitializer$WxaWidgetContextImpl$1 implements Creator<WxaWidgetContextImpl> {
    WxaWidgetInitializer$WxaWidgetContextImpl$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new WxaWidgetContextImpl(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WxaWidgetContextImpl[i];
    }
}
