package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import org.json.JSONObject;

final class aj extends d {
    aj() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        String str2;
        if (jVar.irP.iqz.pP(str) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
            str2 = "ok";
        } else {
            str2 = String.format("fail no such file or directory \"%s\"", new Object[]{str});
        }
        return new a(str2, new Object[0]);
    }
}
