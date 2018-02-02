package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class as extends d {
    as() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j pX = jVar.irP.iqz.pX(str);
        switch (1.jjG[pX.ordinal()]) {
            case 1:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 2:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case 3:
                return new a("fail operation not permitted, unlink \"%s\"", new Object[]{str});
            case 4:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + pX.name(), new Object[0]);
        }
    }
}
