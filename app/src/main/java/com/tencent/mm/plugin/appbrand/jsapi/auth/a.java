package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.plugin.appbrand.q.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class a extends e<a> implements com.tencent.mm.plugin.appbrand.jsapi.auth.b.a {
    private static final Map<String, a> jfO = new android.support.v4.e.a();
    private static final a jfP = new 1();

    protected /* synthetic */ boolean afE() {
        return afD();
    }

    protected /* synthetic */ void bc(Object obj) {
        a((a) obj);
    }

    public static a o(com.tencent.mm.plugin.appbrand.e eVar) {
        if (eVar == null || eVar.mFinished) {
            return jfP;
        }
        a aVar;
        synchronized (jfO) {
            aVar = (a) jfO.get(eVar.mAppId);
            if (aVar == null) {
                aVar = new a(eVar);
                jfO.put(eVar.mAppId, aVar);
            }
        }
        return aVar;
    }

    private a(com.tencent.mm.plugin.appbrand.e eVar) {
        super("MicroMsg.AppBrandAuthJsApiQueue" + (eVar == null ? "|DUMMY" : "|" + eVar.mAppId), c.Dm().oAt.getLooper());
        if (eVar != null) {
            String str = eVar.mAppId;
            com.tencent.mm.plugin.appbrand.c.a(str, new 2(this, str));
        }
    }

    public final void afC() {
        Dh(2);
    }

    protected boolean afD() {
        return false;
    }

    protected final void a(a aVar) {
        x.d(this.mName, "about to executeTask %s", new Object[]{aVar.toString()});
        aVar.afF();
    }
}
