package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class WidgetSysConfig$1 implements Creator<WidgetSysConfig> {
    WidgetSysConfig$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
        widgetSysConfig.iNy = parcel.readInt();
        widgetSysConfig.iNz = parcel.readInt();
        widgetSysConfig.iNA = parcel.readInt();
        return widgetSysConfig;
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new WidgetSysConfig[i];
    }
}
