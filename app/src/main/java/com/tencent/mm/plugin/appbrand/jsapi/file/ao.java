package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import org.json.JSONObject;

final class ao extends d {
    ao() {
    }

    final a a(j jVar, String str, JSONObject jSONObject) {
        e eVar;
        String optString = jSONObject.optString("encoding");
        x.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", new Object[]{str, optString});
        if (bh.ov(optString)) {
            eVar = null;
        } else {
            e eVar2 = (e) e.a.jjv.get(optString.toLowerCase());
            if (eVar2 == null) {
                return new a("fail invalid encoding", new Object[0]);
            }
            eVar = eVar2;
        }
        h hVar = new h();
        com.tencent.mm.plugin.appbrand.appstorage.j a = jVar.irP.iqz.a(str, hVar);
        if (a == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
            Object obj;
            if (eVar == null) {
                obj = (Comparable) hVar.jRK;
            } else {
                String h = eVar.h((ByteBuffer) hVar.jRK);
            }
            if (!(obj instanceof ByteBuffer)) {
                com.tencent.mm.plugin.appbrand.k.a.i((ByteBuffer) hVar.jRK);
            }
            return new a("ok", new Object[0]).s(SlookAirButtonFrequentContactAdapter.DATA, obj);
        }
        switch (1.jjG[a.ordinal()]) {
            case 1:
                return new a("fail no such file \"%s\"", new Object[]{str});
            case 2:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 3:
                return new a("fail \"%s\" is not a regular file", new Object[]{str});
            default:
                return new a("fail " + a.name(), new Object[0]);
        }
    }
}
