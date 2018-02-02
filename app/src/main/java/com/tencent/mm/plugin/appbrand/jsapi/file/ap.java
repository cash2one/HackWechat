package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

final class ap extends d {
    ap() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        String format = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[]{str, jSONObject.optString("newPath")});
        String format2 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[]{str, r0});
        File pQ = jVar.irP.iqz.pQ(str);
        if (pQ == null || !pQ.exists()) {
            return new a(format, new Object[0]);
        }
        if (k.u(pQ)) {
            return new a("fail \"%s\" not a regular file", new Object[]{str});
        }
        com.tencent.mm.plugin.appbrand.appstorage.j a = jVar.irP.iqz.a(r0, pQ, true);
        switch (1.jjG[a.ordinal()]) {
            case 1:
                return new a(format2, new Object[0]);
            case 2:
                return new a(format, new Object[0]);
            case 3:
                return new a("fail sdcard not mounted", new Object[0]);
            case 4:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }

    protected final String o(JSONObject jSONObject) {
        return jSONObject.optString("oldPath");
    }
}
