package com.tencent.mm.plugin.appbrand.dynamic.d.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.dynamic.i.a;
import com.tencent.mm.plugin.appbrand.p.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.c.b;
import com.tencent.mm.v.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c implements b {
    private Handler iTB;
    public a iTC;

    public c() {
        HandlerThread handlerThread = new HandlerThread("JsApiExecutor-Thread:" + hashCode());
        handlerThread.start();
        this.iTB = new Handler(handlerThread.getLooper());
    }

    public final String fr(String str) {
        x.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) do not exist.", new Object[]{str});
        return G(str, "fail:not supported");
    }

    public final String a(com.tencent.mm.u.c.a aVar, com.tencent.mm.u.d.a aVar2, com.tencent.mm.u.b.b bVar, String str, com.tencent.mm.u.b.b.a aVar3) {
        String str2 = "";
        String str3 = bVar.name;
        if (aVar2.gn(bVar.index)) {
            String a;
            String bG = k.bG(System.nanoTime());
            boolean qs = d.qs(str3);
            com.tencent.mm.plugin.appbrand.collector.c.b("jsapi_draw_canvas", bG, "start_jsapi_invoke", qs);
            com.tencent.mm.plugin.appbrand.collector.c.aS(bG, "after_draw_actions");
            if (bVar instanceof b) {
                JSONObject ru = ru(str);
                if (ru == null) {
                    return G(str3, "fail:invalid data");
                }
                a = bVar.a(aVar, ru, aVar3);
            } else {
                this.iTB.post(new 1(this, bG, qs, str, aVar3, str3, bVar, aVar));
                a = str2;
            }
            if (this.iTC == null) {
                return a;
            }
            this.iTC.rw(str3);
            return a;
        }
        x.i("MicroMsg.DefaultJsApiExecutor", "JsApiFunc(%s) no permission.", new Object[]{str3});
        return G(str3, "fail:access denied");
    }

    public final void quit() {
        this.iTB.getLooper().quit();
        if (this.iTC != null) {
            this.iTC.wW();
        }
    }

    static JSONObject ru(String str) {
        try {
            if (bh.ov(str)) {
                str = "{}";
            }
            long nanoTime = System.nanoTime();
            JSONObject fy = g.fy(str);
            com.tencent.mm.plugin.appbrand.dynamic.i.b.f(System.nanoTime() - nanoTime, str.length());
            return fy;
        } catch (Throwable e) {
            x.e("MicroMsg.DefaultJsApiExecutor", Log.getStackTraceString(e));
            return null;
        }
    }

    public final String G(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("errMsg", str + ":" + str2);
        return new JSONObject(hashMap).toString();
    }
}
