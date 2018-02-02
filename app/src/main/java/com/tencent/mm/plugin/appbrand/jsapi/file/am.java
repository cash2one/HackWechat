package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class am extends d {
    am() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j pV = jVar.irP.iqz.pV(str);
        switch (1.jjG[pV.ordinal()]) {
            case 1:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case 2:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 3:
                return new a("fail file already exists \"%s\"", new Object[]{str});
            case 4:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + pV.name(), new Object[0]);
        }
    }
}
