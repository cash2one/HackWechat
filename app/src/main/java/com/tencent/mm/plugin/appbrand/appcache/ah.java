package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.m;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ah {
    public static final String[] iFc = y.iFc;
    private static final Map<e, ah> iGm = new HashMap();
    private static final ah iGn = new 1();
    private final k iGo;
    private final String mAppId;

    static /* synthetic */ void b(ah ahVar) {
        if (ahVar.iGo != null) {
            ahVar.iGo.close();
        }
    }

    public static void j(e eVar) {
        ah l = l(eVar);
        if (l != null && l.iGo != null) {
            l.iGo.ZK();
        }
    }

    public static k k(e eVar) {
        return l(eVar).iGo;
    }

    public static String a(e eVar, String str) {
        return bh.ou((String) l(eVar).f(str, String.class));
    }

    public static boolean b(e eVar, String str) {
        Closeable d = d(eVar, str);
        if (d == null) {
            return false;
        }
        bh.d(d);
        return true;
    }

    public static m c(e eVar, String str) {
        return (m) l(eVar).f(str, m.class);
    }

    public static InputStream d(e eVar, String str) {
        return (InputStream) l(eVar).f(str, InputStream.class);
    }

    public static byte[] e(e eVar, String str) {
        return (byte[]) l(eVar).f(str, byte[].class);
    }

    public static String f(e eVar, String str) {
        return m.a(l(eVar).iGo.pC("__APP__"), str);
    }

    private static ah l(e eVar) {
        if (eVar == null) {
            return iGn;
        }
        ah ahVar;
        synchronized (iGm) {
            ahVar = (ah) iGm.get(eVar);
            if (ahVar == null) {
                ahVar = new ah(eVar);
                iGm.put(eVar, ahVar);
            }
        }
        return ahVar;
    }

    private ah(final e eVar) {
        if (eVar == null) {
            this.iGo = null;
            this.mAppId = null;
            return;
        }
        this.mAppId = eVar.mAppId;
        this.iGo = new k(eVar.iqx.iOI);
        this.iGo.ZK();
        c.a(this.mAppId, new b(this) {
            final /* synthetic */ ah iGp;

            public final void onDestroy() {
                c.b(this.iGp.mAppId, this);
                synchronized (ah.iGm) {
                    ah.iGm.remove(eVar);
                }
                ah.b(this.iGp);
            }
        });
    }

    protected <T> T f(String str, Class<T> cls) {
        T t = null;
        boolean z = true;
        boolean z2 = bh.ov(str) ? true : s.eE(str, "about:blank") ? true : com.tencent.mm.plugin.appbrand.p.c.uz(str);
        if (!z2) {
            InputStream pD;
            String py = a.py(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (a.a(iFc, py)) {
                pD = v.pD(py);
            } else {
                z pB = this.iGo.pB(py);
                pD = pB == null ? null : pB.pI(py);
            }
            if (pD != null) {
                t = ((b) a.iGq.get(cls)).c(py, pD);
            }
            String str2 = "MicroMsg.WxaPkgRuntimeReader";
            String str3 = "openRead, appId = %s, reqURL = %s, null(%B), type = %s, cost = %dms";
            Object[] objArr = new Object[5];
            objArr[0] = this.mAppId;
            objArr[1] = py;
            if (t != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = cls.getName();
            objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            x.i(str2, str3, objArr);
        }
        return t;
    }
}
