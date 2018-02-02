package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Handler;
import android.os.HandlerThread;
import android.webkit.JavascriptInterface;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.game.d.c;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    boolean Vx;
    public Handler iTB;
    final c jbL;
    private final b jbM;
    private final Map<String, e> jbN;
    private int jbO;
    private ConcurrentHashMap<Integer, String> jbP;

    public d(j jVar, b bVar) {
        this(jVar, bVar, g.aft());
    }

    public d(p pVar, b bVar) {
        this(pVar, bVar, g.afu());
    }

    public d(com.tencent.mm.plugin.appbrand.game.d dVar, b bVar) {
        this(dVar, bVar, c.ael());
    }

    private d(c cVar, b bVar, Map<String, e> map) {
        this.jbO = 0;
        this.jbP = new ConcurrentHashMap();
        this.jbL = cVar;
        this.jbM = bVar;
        this.Vx = true;
        this.jbN = map;
        HandlerThread handlerThread = new HandlerThread("AppBrandAsyncJSThread");
        handlerThread.start();
        this.iTB = new Handler(handlerThread.getLooper());
    }

    public final void cleanup() {
        this.iTB.getLooper().quit();
        this.Vx = false;
        this.jbP.clear();
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void publishHandler(String str, String str2, String str3) {
        int i = 0;
        this.iTB.post(new 1(this, str, str2, str3));
        String str4 = "MicroMsg.AppBrandJSInterface";
        String str5 = "publishHandler, event: %s, data size: %d, data : %s";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (str2 != null) {
            i = str2.length();
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = str2;
        x.d(str4, str5, objArr);
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String invokeHandler(String str, String str2, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        String str3 = "";
        try {
            int a = this.jbL.a(this.jbM, i);
            e eVar = (e) this.jbN.get(str);
            if (eVar == null) {
                this.jbL.E(a, G(str, "fail:not supported"));
                return "fail:not supported";
            }
            String str4;
            String a2;
            boolean z = eVar instanceof l;
            h hVar = this.jbL.jbH;
            c cVar = this.jbL;
            if (this.jbL.YQ() == null) {
                str4 = "";
            } else {
                n nVar = this.jbL.YQ().iqC;
                str4 = (nVar == null || nVar.aiT() == null) ? "" : nVar.aiT().aeq();
            }
            hVar.jcd.put(Integer.valueOf(a), new a(cVar, eVar, str2, System.currentTimeMillis(), str4));
            if (z) {
                a2 = a(str, str2, a, true);
            } else {
                this.iTB.post(new 2(this, str, str2, a));
                a2 = str3;
            }
            if ((!com.tencent.mm.compatible.loader.a.a(m.jcm, eVar.getClass()) ? 1 : null) == null) {
                return a2;
            }
            int i2;
            String str5 = "MicroMsg.AppBrandJSInterface";
            String str6 = "invokeHandler, api: %s, data size: %d, sync: %b, time: %d";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            if (str2 == null) {
                i2 = 0;
            } else {
                i2 = str2.length();
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            x.i(str5, str6, objArr);
            return a2;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandJSInterface", e, " Invoke Error %s", str);
            throw e;
        }
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final String retrieveEvent(int i) {
        String str = (String) this.jbP.get(Integer.valueOf(i));
        this.jbP.remove(Integer.valueOf(i));
        return str == null ? "" : str;
    }

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final boolean isDebugPackage() {
        return com.tencent.mm.sdk.a.b.ceK();
    }

    private String a(String str, String str2, int i, boolean z) {
        if (this.jbL.YQ() == null || !this.jbL.isRunning()) {
            return G(str, "fail:interrupted");
        }
        e eVar = (e) this.jbN.get(str);
        com.tencent.mm.plugin.appbrand.permission.c.a a = com.tencent.mm.plugin.appbrand.permission.c.r(this.jbL.YQ()).a(this.jbL, eVar, new 3(this, str, str2, i, z, eVar));
        if (3 == a.code) {
            return "";
        }
        String e;
        if (a.code != 1) {
            e = eVar.e(a.fpb, null);
        } else {
            JSONObject sc = sc(str2);
            if (sc == null) {
                e = eVar.e("fail:invalid data", null);
            } else if (z) {
                e = ((l) eVar).a(this.jbL, sc);
            } else {
                ((a) eVar).a(this.jbL, sc, i);
                e = null;
            }
        }
        if (e != null) {
            this.jbL.jbH.H(i, e);
        }
        if (!z) {
            if (e != null) {
                this.jbL.E(i, e);
            }
            return "";
        } else if (bh.ov(e)) {
            return "{}";
        } else {
            return e;
        }
    }

    private static JSONObject sc(String str) {
        try {
            if (bh.ov(str)) {
                str = "{}";
            }
            return new JSONObject(str);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return null;
        }
    }

    private static String G(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }

    static int[] sd(String str) {
        int[] iArr;
        Exception e;
        int[] iArr2 = new int[0];
        try {
            JSONArray jSONArray = new JSONArray(str);
            iArr = new int[jSONArray.length()];
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    iArr[i] = jSONArray.getInt(i);
                    i++;
                } catch (Exception e2) {
                    e = e2;
                }
            }
        } catch (Exception e3) {
            Exception exception = e3;
            iArr = iArr2;
            e = exception;
            x.e("MicroMsg.AppBrandJSInterface", e.getMessage());
            return iArr;
        }
        return iArr;
    }
}
