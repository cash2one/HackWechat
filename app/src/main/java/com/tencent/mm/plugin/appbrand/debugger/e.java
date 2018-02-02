package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ac;

final class e implements a {
    e() {
    }

    public final String name() {
        return "LaunchApp";
    }

    public final void t(Intent intent) {
        String stringExtra = intent.getStringExtra("username");
        String stringExtra2 = intent.getStringExtra("appId");
        String stringExtra3 = intent.getStringExtra("path");
        int intExtra = intent.getIntExtra("versionType", 0);
        int intExtra2 = intent.getIntExtra("scene", 1030);
        String stringExtra4 = intent.getStringExtra("sceneNote");
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = intExtra2;
        appBrandStatObject.fnp = stringExtra4;
        ((c) g.h(c.class)).a(ac.getContext(), stringExtra, stringExtra2, intExtra, 0, stringExtra3, appBrandStatObject);
    }
}
