package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class h {
    private static boolean jvS = false;

    public static b bZ(Context context) {
        b jVar;
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
        Object obj = (!sharedPreferences.getBoolean("switch_x5_jscore", true) || "1".equals(sharedPreferences.getString("tbs_webview_disable", "0")) || jvS) ? 1 : null;
        if (obj != null) {
            jVar = new j(context);
        } else {
            b iVar = new i(context);
            if (((i) iVar).jvT.isValid()) {
                jVar = iVar;
            } else {
                jvS = true;
                iVar.destroy();
                jVar = new j(context);
            }
        }
        if (jVar instanceof j) {
            g.pQN.a(434, 1, 1, false);
            x.i("MicroMsg.AppBrandJsRuntimeFactory", "Using WebView Based Javascript Engine");
        } else {
            g.pQN.a(434, !((i) jVar).jvT.isValid() ? 1 : 2, 1, false);
            x.i("MicroMsg.AppBrandJsRuntimeFactory", "Using v8 Javascript Engine, probably");
        }
        g.pQN.a(434, 0, 1, false);
        return jVar;
    }
}
