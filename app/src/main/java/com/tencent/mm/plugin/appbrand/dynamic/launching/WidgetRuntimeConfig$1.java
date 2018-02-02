package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class WidgetRuntimeConfig$1 implements Creator<WidgetRuntimeConfig> {
    WidgetRuntimeConfig$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = true;
        WidgetRuntimeConfig widgetRuntimeConfig = new WidgetRuntimeConfig();
        widgetRuntimeConfig.appId = parcel.readString();
        widgetRuntimeConfig.iUf = parcel.readInt();
        widgetRuntimeConfig.iUv = parcel.readInt();
        widgetRuntimeConfig.iUw = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        widgetRuntimeConfig.iUx = z;
        return widgetRuntimeConfig;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WidgetRuntimeConfig[i];
    }
}
