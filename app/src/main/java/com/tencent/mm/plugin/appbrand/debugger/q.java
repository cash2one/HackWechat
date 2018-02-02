package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.d$a;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.x;

public final class q {
    public static void a(e eVar, b bVar, String str) {
        if (eVar == null || bVar == null || str == null || str.length() == 0) {
            x.w("MicroMsg.SourceMapInjector", "runtime or jsRuntime or filePath is null.");
        } else if (d$a.jv(eVar.iqx.iOI.iGK)) {
            x.i("MicroMsg.SourceMapInjector", "current running type is ReleaseType do not need to inject sourceMap.");
        } else {
            String a = ah.a(eVar, str + ".map");
            if (a == null || a.length() == 0) {
                x.i("MicroMsg.SourceMapInjector", "sourceMap of the script(%s) is null or nil.", new Object[]{str});
                return;
            }
            h.a(bVar, String.format("var __wxSourceMap ={ '%s': %s };", new Object[]{str, a}), new 2(str));
        }
    }

    public static String rl(String str) {
        return "https://servicewechat.qq.com/" + str;
    }
}
