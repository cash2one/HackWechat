package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.Context;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public interface g {
    public static final g jzg = (((h) com.tencent.mm.kernel.g.Dg().CN()).DS() ? new i() : new c());

    boolean a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional);
}
