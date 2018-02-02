package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.os.Build.VERSION;
import com.tencent.mm.plugin.appbrand.appcache.ah;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.q;
import com.tencent.mm.plugin.appbrand.debugger.q.1;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.g.e;
import com.tencent.mm.plugin.appbrand.g.h;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.p.l;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class j extends c {
    public volatile boolean Vx = true;
    public e irP;
    public d irQ = YN();
    public b irR = YM();
    public m irS = new m(this);
    protected LinkedList<a> irT = new LinkedList();
    public boolean irU = false;
    private boolean irV = false;
    private long irW = System.currentTimeMillis();
    public long irX;
    public String mAppId;

    public j() {
        this.irR.a(new 1(this));
        this.irX = System.currentTimeMillis() - this.irW;
    }

    public b YM() {
        return h.bZ(ac.getContext());
    }

    public d YN() {
        d dVar = new d(this, this.irR);
        this.irR.addJavascriptInterface(dVar, "WeixinJSCore");
        return dVar;
    }

    public void f(e eVar) {
        x.i("MicroMsg.AppBrandService", "onRuntimeReady, mPreLoadWebView %b", new Object[]{Boolean.valueOf(this.irU)});
        this.irP = eVar;
        this.mAppId = eVar.mAppId;
        if (this.irR.v(e.class) != null) {
            ((e) this.irR.v(e.class)).sX(String.format("https://servicewechat.com/%s/js-engine", new Object[]{this.mAppId}));
        }
    }

    public void init() {
        YS();
        YP();
        String a = ah.a(this.irP, "app-service.js");
        g.pQN.a(370, 9, 1, false);
        com.tencent.mm.plugin.appbrand.q.h.a(this.irR, "app-service.js", a, new 6(this));
        q.a(this.irP, this.irR, "app-service.js");
        e eVar = this.irP;
        b bVar = this.irR;
        if (eVar == null || bVar == null) {
            x.w("MicroMsg.SourceMapInjector", "runtime or jsRuntime is null.");
        } else if (a.jv(eVar.iqx.iOI.iGK)) {
            x.i("MicroMsg.SourceMapInjector", "current running type is ReleaseType do not need to inject sourceMap.");
        } else {
            a = v.pE("WASourceMap.js");
            if (a == null || a.length() == 0) {
                x.w("MicroMsg.SourceMapInjector", "WASourceMap.js is null or nil");
            } else {
                com.tencent.mm.plugin.appbrand.q.h.a(bVar, a, new 1());
            }
        }
        YO();
    }

    public void pn(String str) {
        String str2 = str + (str.endsWith("/") ? "" : "/") + "app-service.js";
        String a = ah.a(this.irP, str2);
        g.pQN.a(370, 30, 1, false);
        com.tencent.mm.plugin.appbrand.q.h.a(this.irR, str2, a, new 2(this, str));
        q.a(this.irP, this.irR, str2);
    }

    public final synchronized void YO() {
        Iterator it = this.irT.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            super.h(aVar.fok, aVar.data, aVar.src);
        }
        this.irT = null;
    }

    public void YP() {
        if (!this.irV) {
            this.irV = true;
            com.tencent.mm.plugin.appbrand.q.h.a(this.irR, com.tencent.mm.plugin.appbrand.p.c.uy("wxa_library/android.js"), new 3(this));
            com.tencent.mm.plugin.appbrand.q.h.a(this.irR, v.pE("WAService.js"), new com.tencent.mm.plugin.appbrand.q.h.a(this) {
                final /* synthetic */ j irY;

                {
                    this.irY = r1;
                }

                public final void po(String str) {
                    x.i("MicroMsg.AppBrandService", "Inject SDK Service Script Success");
                    g.pQN.a(370, 7, 1, false);
                }

                public final void fq(String str) {
                    int i = 0;
                    x.e("MicroMsg.AppBrandService", "Inject SDK Service Script Failed: %s", new Object[]{str});
                    g.pQN.a(370, 6, 1, false);
                    com.tencent.mm.plugin.appbrand.report.a.z(this.irY.mAppId, 24, 0);
                    int i2 = -1;
                    if (this.irY.irP != null) {
                        i = this.irY.irP.iqx.iOI.iGL;
                        i2 = this.irY.irP.iqx.iOI.iGK;
                    }
                    com.tencent.mm.plugin.appbrand.report.a.a(this.irY.mAppId, i, i2, 370, 6);
                }
            });
            g.pQN.a(370, 5, 1, false);
        }
        if (this.irP != null) {
            String str = "";
            if (AppBrandPerformanceManager.tT(this.mAppId)) {
                str = v.pE("WAPerf.js");
            }
            if (bh.ov(str)) {
                x.i("MicroMsg.AppBrandService", "execInternalInitScript, js null");
            } else {
                com.tencent.mm.plugin.appbrand.q.h.a(this.irR, str, new 5(this));
            }
        }
    }

    public void h(String str, String str2, int i) {
        synchronized (this) {
            if (this.irT != null) {
                this.irT.add(new a(str, str2, i));
                return;
            }
            super.h(str, str2, i);
        }
    }

    public final void a(String str, String str2, int[] iArr) {
        this.irP.iqC.c(str, str2, iArr);
    }

    public final boolean isRunning() {
        return this.Vx;
    }

    public final Activity getContext() {
        return this.irP == null ? null : this.irP.iqt;
    }

    public final String getAppId() {
        return this.mAppId;
    }

    public final e YQ() {
        return this.irP;
    }

    public final b YR() {
        return this.irR;
    }

    public void cleanup() {
        super.cleanup();
        this.Vx = false;
        this.irR.destroy();
        this.irQ.cleanup();
    }

    public void YS() {
        JSONObject YT = YT();
        String str = this.irP.iqy.iMF;
        this.irR.evaluateJavascript(String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{YT.toString(), str}), null);
        if (this.irU) {
            super.h("onWxConfigReady", "", 0);
        }
    }

    public final JSONObject YT() {
        JSONObject jSONObject = new JSONObject();
        AppBrandSysConfig appBrandSysConfig = this.irP.iqx;
        com.tencent.mm.plugin.appbrand.config.a aVar = this.irP.iqy;
        if (appBrandSysConfig == null || aVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject2 = aVar.iME;
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            try {
                jSONObject.putOpt(str, jSONObject2.opt(str));
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandService", e.getMessage());
            }
        }
        a(jSONObject, "appType", Integer.valueOf(this.irP.iqw.fnv));
        a(jSONObject, "debug", Boolean.valueOf(this.irP.iqx.iOi));
        a(jSONObject, "downloadDomain", appBrandSysConfig.iOD);
        e(jSONObject);
        Object jSONObject3 = new JSONObject();
        a((JSONObject) jSONObject3, "scene", Integer.valueOf(this.irP.Yw()));
        String Yx = this.irP.Yx();
        a((JSONObject) jSONObject3, "path", l.uB(Yx));
        a((JSONObject) jSONObject3, "query", new JSONObject(l.uC(Yx)));
        a((JSONObject) jSONObject3, "topBarStatus", Boolean.valueOf(this.irP.iqw.iNX));
        a((JSONObject) jSONObject3, "referrerInfo", this.irP.iqw.iNZ.abW());
        a((JSONObject) jSONObject3, "shareInfo", this.irP.iqw.abU());
        a((JSONObject) jSONObject3, "isSticky", Boolean.valueOf(this.irP.iqw.iNX));
        Object jSONObject4 = new JSONObject();
        try {
            a((JSONObject) jSONObject4, "template", new JSONArray(appBrandSysConfig.iOh));
        } catch (Exception e2) {
        }
        a((JSONObject) jSONObject4, "maxRequestConcurrent", Integer.valueOf(appBrandSysConfig.iOq));
        a((JSONObject) jSONObject4, "maxUploadConcurrent", Integer.valueOf(appBrandSysConfig.iOr));
        a((JSONObject) jSONObject4, "maxDownloadConcurrent", Integer.valueOf(appBrandSysConfig.iOs));
        a((JSONObject) jSONObject4, "maxWebsocketConnect", Integer.valueOf(appBrandSysConfig.iOt));
        a((JSONObject) jSONObject4, "maxWorkerConcurrent", Integer.valueOf(appBrandSysConfig.iOu));
        a(jSONObject, "appLaunchInfo", jSONObject3);
        a(jSONObject, "wxAppInfo", jSONObject4);
        a(jSONObject, "isPluginMiniProgram", Boolean.valueOf(this.irP.Yy()));
        jSONObject3 = new JSONObject();
        a((JSONObject) jSONObject3, "USER_DATA_PATH", (Object) "wxfile://usr");
        a(jSONObject, "env", jSONObject3);
        a(jSONObject, "appContactInfo", bh.az(this.irP.iqw.iNU, "{}"));
        return d(jSONObject);
    }

    public JSONObject d(JSONObject jSONObject) {
        return jSONObject;
    }

    public void e(JSONObject jSONObject) {
        a(jSONObject, "platform", (Object) "android");
        a(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vAz));
        a(jSONObject, "nativeBufferEnabled", Boolean.valueOf(this.irR.v(com.tencent.mm.plugin.appbrand.g.d.class) != null));
        a(jSONObject, "system", "Android " + VERSION.RELEASE);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.AppBrandService", e.getMessage());
        }
    }
}
