package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class b extends a {
    public b(int i) {
        super(com.tencent.mm.plugin.appbrand.jsapi.c.b.NAME, i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, com.tencent.mm.u.b.b.a<JSONObject> aVar2) {
        c.aR(d.h(jSONObject), "before_jsapi_invoke");
        com.tencent.mm.z.u.b Cb = aVar.Cb();
        String string = Cb.getString("__page_view_id", null);
        String string2 = Cb.getString("__process_name", ac.Br());
        if (com.tencent.mm.plugin.appbrand.dynamic.d.acE().rm(string) == null) {
            x.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", new Object[]{string});
            aVar2.aw(a(false, "got 'null' when get view by the given viewId", null));
            return;
        }
        Object obj;
        long j;
        synchronized (Cb) {
            long longValue;
            long currentTimeMillis = System.currentTimeMillis();
            CharSequence rt = rt("lastTime");
            if (!TextUtils.isEmpty(rt)) {
                obj = Cb.hfv.get(rt);
                if (obj instanceof Long) {
                    longValue = ((Long) obj).longValue();
                    j = currentTimeMillis - longValue;
                }
            }
            longValue = 0;
            j = currentTimeMillis - longValue;
        }
        obj = (a) Cb.get(rt("DrawCanvasRunnable"), null);
        if (obj == null) {
            obj = new a((byte) 0);
            Cb.o(rt("DrawCanvasRunnable"), obj);
        }
        obj.process = string2;
        obj.iTh = string;
        obj.iTi = jSONObject;
        obj.iTj = this;
        obj.iTk = aVar2;
        obj.iTl = Cb;
        com.tencent.mm.plugin.appbrand.dynamic.b.acC().removeCallbacks(obj);
        if (j < 16) {
            x.v("MicroMsg.JsApiFunc_DrawCanvas", "postDelayed(%s)", new Object[]{Long.valueOf(j)});
            com.tencent.mm.plugin.appbrand.dynamic.b.acC().postDelayed(obj, j);
            return;
        }
        obj.run();
    }

    final String rt(String str) {
        return this.name + "#" + str;
    }
}
