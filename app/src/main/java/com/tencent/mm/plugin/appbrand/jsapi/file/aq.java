package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class aq extends d {
    aq() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j pW = jVar.irP.iqz.pW(str);
        switch (pW) {
            case ERR_PARENT_DIR_NOT_EXISTS:
            case RET_NOT_EXISTS:
                return new a("fail no such file or directory \"%s\"", new Object[]{str});
            case ERR_DIR_NOT_EMPTY:
                return new a("fail directory not empty", new Object[0]);
            case ERR_PERMISSION_DENIED:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case OK:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + pW.name(), new Object[0]);
        }
    }
}
