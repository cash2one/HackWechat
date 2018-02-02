package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public interface WxaWidgetContext extends Parcelable {
    WxaPkgWrappingInfo acH();

    WxaPkgWrappingInfo acI();

    int acJ();

    int acK();

    byte[] acL();

    int acM();

    DebuggerInfo acN();

    WidgetSysConfig acO();

    WidgetRuntimeConfig acP();

    String getAppId();

    String getId();
}
