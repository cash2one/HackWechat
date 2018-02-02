package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.appcache.ag.c;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.task.d;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Map;

public final class b implements c, a {
    public final void u(Map<String, String> map) {
        if (DebuggerShell.acg()) {
            String str = (String) map.get(".sysmsg.AppBrandForceKill.AppId");
            int i = bh.getInt((String) map.get(".sysmsg.AppBrandForceKill.VersionType"), 0);
            if (!bh.ov(str)) {
                d.aJ(str, i);
            }
        }
    }

    public final String name() {
        return "ForceKillAppNotify";
    }

    public final void t(Intent intent) {
        d.aJ(intent.getStringExtra("appId"), intent.getIntExtra("versionType", 0));
    }
}
