package c.t.m.g;

import android.text.TextUtils;
import c.t.m.g.x.a;

public final class g implements d {
    private static g a = new g();

    private g() {
    }

    public static g a() {
        return a;
    }

    public final e a(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            return new i(str, bArr);
        }
        throw new IllegalArgumentException("url is empty");
    }

    public final f a(e eVar) {
        int i = 0;
        if (eVar == null) {
            throw new RuntimeException("execute...IHttpRequest is null");
        } else if (eVar instanceof i) {
            i iVar = (i) eVar;
            iVar.l = System.currentTimeMillis();
            v.a("app_http_use_proxy", 0, 1, 1);
            k lVar = new l(iVar);
            if (iVar.h <= 0) {
                iVar.a(lVar.a());
            } else {
                a.a().a.execute(new h(lVar, iVar));
                if (!iVar.c()) {
                    i = 1;
                }
            }
            aj d = iVar.d();
            if (i != 0) {
                iVar.k = true;
            }
            return new j(d == null ? new aj(-14, "force return timeout:" + iVar.h) : d);
        } else {
            throw new RuntimeException("execute...IHttpRequest should be create by API:createRequest");
        }
    }
}
