package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.sdk.platformtools.bh;
import java.io.Closeable;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ak extends d {
    ak() {
    }

    final f$a a(j jVar, String str, JSONObject jSONObject) {
        com.tencent.mm.plugin.appbrand.appstorage.j d;
        String optString = jSONObject.optString("destPath");
        String format = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        String format2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[]{str, optString});
        File pQ = jVar.irP.iqz.pQ(str);
        if (pQ == null || !pQ.exists() || !pQ.isFile()) {
            h hVar = new h();
            jVar.irP.iqz.a(str, hVar);
            if (hVar.jRK == null) {
                return new f$a(format, new Object[0]);
            }
            Closeable aVar = new a((ByteBuffer) hVar.jRK);
            d = jVar.irP.iqz.d(optString, aVar);
            bh.d(aVar);
        } else if (k.u(pQ)) {
            return new f$a("fail \"%s\" not a regular file", str);
        } else {
            d = jVar.irP.iqz.a(optString, pQ, false);
        }
        switch (1.jjG[d.ordinal()]) {
            case 1:
                return new f$a(format2, new Object[0]);
            case 2:
                return new f$a(format, new Object[0]);
            case 3:
                return new f$a("fail sdcard not mounted", new Object[0]);
            case 4:
                return new f$a("fail illegal operation on a directory, open \"%s\"", optString);
            case 5:
                return new f$a("fail \"%s\" is not a regular file", optString);
            case 6:
                return new f$a("ok", new Object[0]);
            default:
                return new f$a("fail " + d.name(), new Object[0]);
        }
    }

    protected final String o(JSONObject jSONObject) {
        return jSONObject.optString("srcPath");
    }
}
