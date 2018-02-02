package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.jsapi.file.f.a;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.json.JSONObject;

final class au extends d {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] jjG = new int[j.values().length];

        static {
            try {
                jjG[j.iIw.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                jjG[j.iIy.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                jjG[j.iIx.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                jjG[j.iID.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                jjG[j.iIt.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    au() {
    }

    final a a(com.tencent.mm.plugin.appbrand.j jVar, String str, JSONObject jSONObject) {
        InputStream aVar;
        String optString = jSONObject.optString("encoding");
        l.a(jVar, jSONObject, this.jju);
        Object opt = jSONObject.opt(SlookAirButtonFrequentContactAdapter.DATA);
        if (opt instanceof String) {
            e eVar;
            if (bh.ov(optString)) {
                eVar = (e) e.a.jjv.get("utf8");
            } else {
                e eVar2 = (e) e.a.jjv.get(optString.toLowerCase());
                if (eVar2 == null) {
                    return new a("fail invalid encoding", new Object[0]);
                }
                eVar = eVar2;
            }
            try {
                aVar = new com.tencent.mm.plugin.appbrand.k.a(eVar.so((String) opt));
            } catch (Exception e) {
                return new a("fail " + e.getMessage(), new Object[0]);
            }
        } else if (opt instanceof ByteBuffer) {
            aVar = new com.tencent.mm.plugin.appbrand.k.a((ByteBuffer) opt);
        } else if (opt != null) {
            return new a("fail invalid data", new Object[0]);
        } else {
            aVar = new ByteArrayInputStream(new byte[0]);
        }
        j d = jVar.irP.iqz.d(str, aVar);
        switch (AnonymousClass1.jjG[d.ordinal()]) {
            case 1:
                return new a("fail no such file or directory, open \"%s\"", new Object[]{str});
            case 2:
                return new a("fail illegal operation on a directory, open \"%s\"", new Object[]{str});
            case 3:
                return new a("fail permission denied, open \"%s\"", new Object[]{str});
            case 4:
                return new a("fail \"%s\" is not a regular file", new Object[]{str});
            case 5:
                return new a("ok", new Object[0]);
            default:
                return new a("fail " + d.name(), new Object[0]);
        }
    }
}
