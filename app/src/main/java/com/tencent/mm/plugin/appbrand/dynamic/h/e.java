package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appcache.y;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.n;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.d;
import com.tencent.mm.u.c.b;
import com.tencent.mm.u.c.f;
import com.tencent.mm.u.d.a;
import com.tencent.rtmp.TXLiveConstants;
import org.json.JSONObject;

public class e {
    private static volatile com.tencent.mm.u.c.e iUF;
    private static volatile DebuggerInfo iUG;
    private static volatile boolean iUH;

    public static com.tencent.mm.u.c.e a(Context context, WxaWidgetContext wxaWidgetContext, a aVar, Bundle bundle) {
        com.tencent.mm.u.c.e eVar;
        String convertStreamToString;
        synchronized (e.class) {
            eVar = iUF;
            iUF = null;
        }
        if (eVar == null) {
            eVar = a(wxaWidgetContext.acN());
        }
        int i = bundle.getInt("widget_type");
        b cVar = new c();
        if (i == 1) {
            cVar.iTC = new com.tencent.mm.plugin.appbrand.dynamic.i.c(wxaWidgetContext.getAppId(), bundle.getString("search_id"));
        }
        com.tencent.mm.u.c.c cVar2 = new com.tencent.mm.u.c.c(context, eVar, aVar, cVar);
        cVar2.gOI = n.jV(i);
        eVar.gOQ = cVar2;
        d dVar = eVar.gOS;
        eVar.gOR = new f(dVar, com.tencent.mm.plugin.appbrand.dynamic.f.a.jW(i), aVar);
        eVar.gOU = com.tencent.mm.plugin.appbrand.dynamic.debugger.a.acT();
        WidgetRuntimeConfig acP = wxaWidgetContext.acP();
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, "widgetType", Integer.valueOf(acP.iUf));
        b(jSONObject, "platform", "android");
        b(jSONObject, "debug", Boolean.valueOf(wxaWidgetContext.acN().iSR));
        b(jSONObject, "drawMinInterval", Integer.valueOf(wxaWidgetContext.acO().iNA));
        b(jSONObject, "clientVersion", Integer.valueOf(com.tencent.mm.protocal.d.vAz));
        JSONObject jSONObject2 = new JSONObject();
        b(jSONObject2, "drawMinInterval", Integer.valueOf(acP.iUv));
        b(jSONObject2, "timerEnabled", Boolean.valueOf(acP.iUw));
        b(jSONObject2, "drawLock", Boolean.valueOf(acP.iUx));
        dVar.evaluateJavascript(String.format("var __widgetConfig__ = %s;var __wxConfig = %s;var __wxIndexPage = \"%s\"", new Object[]{jSONObject2.toString(), jSONObject.toString(), ""}), null);
        x.v("MicroMsg.PreloadOptimizer", "injectConfig(%s, %s)", new Object[]{wxaWidgetContext.getId(), r1});
        String bb = com.tencent.mm.plugin.appbrand.dynamic.j.c.bb(wxaWidgetContext.getId(), "WAWidget.js");
        if (bh.ov(bb)) {
            convertStreamToString = com.tencent.mm.plugin.appbrand.p.c.convertStreamToString(y.openRead("WAWidget.js"));
        } else {
            convertStreamToString = bb;
        }
        if (bh.ov(convertStreamToString)) {
            x.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
        }
        g.pQN.a(636, 0, 1, false);
        com.tencent.mm.u.a.a(dVar, convertStreamToString, new com.tencent.mm.u.a.a() {
            public final void BU() {
                g.pQN.a(636, 1, 1, false);
            }

            public final void fq(String str) {
                g.pQN.a(636, 2, 1, false);
                x.e("MicroMsg.PreloadOptimizer", "Inject SDK widget Script Failed: %s", new Object[]{str});
            }
        });
        x.v("MicroMsg.PreloadOptimizer", "injectWAWidget(%s)", new Object[]{wxaWidgetContext.getId()});
        convertStreamToString = com.tencent.mm.plugin.appbrand.dynamic.j.c.bb(wxaWidgetContext.getId(), "widget.js");
        if (bh.ov(convertStreamToString)) {
            x.e("MicroMsg.PreloadOptimizer", "get Null Or Nil widget js");
            com.tencent.mm.plugin.appbrand.dynamic.f.acG().au(wxaWidgetContext.getId(), TXLiveConstants.PLAY_WARNING_AUDIO_DECODE_FAIL);
        }
        g.pQN.a(636, 3, 1, false);
        com.tencent.mm.u.a.a(dVar, convertStreamToString, new com.tencent.mm.u.a.a() {
            public final void BU() {
                g.pQN.a(636, 4, 1, false);
            }

            public final void fq(String str) {
                g.pQN.a(636, 5, 1, false);
                x.e("MicroMsg.PreloadOptimizer", "Inject External widget Script Failed: %s", new Object[]{str});
            }
        });
        x.v("MicroMsg.PreloadOptimizer", "injectWidget(%s)", new Object[]{wxaWidgetContext.getId()});
        bR(context);
        return eVar;
    }

    public static void bR(Context context) {
        if (iUH) {
            com.tencent.mm.bz.a.Z(new 1(context));
        }
    }

    private static com.tencent.mm.u.c.e a(DebuggerInfo debuggerInfo) {
        d dVar;
        com.tencent.mm.u.c.e eVar = new com.tencent.mm.u.c.e();
        Object obj = null;
        if (debuggerInfo != null && debuggerInfo.iSS) {
            x.i("MicroMsg.PreloadOptimizer", "debug mode opened, use WebView  JavaScript Engine.");
            obj = 1;
        }
        Context context = ac.getContext();
        String str = "WeixinJSCore";
        String str2 = "https://servicewechat.com/app-widget";
        if (obj != null) {
            dVar = new com.tencent.mm.plugin.appbrand.dynamic.e.d(context, eVar, str, str2);
        } else {
            com.tencent.xweb.g a = com.tencent.xweb.g.a(com.tencent.xweb.g.a.ApS, "support", context);
            dVar = a.isValid() ? new com.tencent.mm.plugin.appbrand.dynamic.e.a(eVar, str, a) : new com.tencent.mm.plugin.appbrand.dynamic.e.d(context, eVar, str, str2);
        }
        if (dVar.Ca()) {
            g.pQN.a(639, 1, 1, false);
            x.i("MicroMsg.PreloadOptimizer", "Using WebView Based Javascript Engine");
        } else {
            g.pQN.a(639, 2, 1, false);
            x.i("MicroMsg.PreloadOptimizer", "Using v8 Javascript Engine");
        }
        g.pQN.a(639, 0, 1, false);
        if (eVar.gOS != null) {
            x.e("MicroMsg.MiniJsBridge", "can not initialize again.");
        } else {
            eVar.gOS = dVar;
        }
        return eVar;
    }

    private static void b(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            x.e("MicroMsg.PreloadOptimizer", "put env arguments error, %s", new Object[]{e});
        }
    }
}
