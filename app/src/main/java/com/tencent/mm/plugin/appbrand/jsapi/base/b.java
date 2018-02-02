package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b extends d {
    public final void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
        a(pVar, i, pVar, jSONObject);
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        p b = b(jVar);
        if (b == null) {
            x.w("MicroMsg.BaseRemoveViewJsApi", "Remove view failed, AppBrandPageView is null.");
            jVar.E(i, e("fail:page is null", null));
            return;
        }
        a(jVar, i, b, jSONObject);
    }

    private void a(c cVar, int i, p pVar, JSONObject jSONObject) {
        try {
            boolean lk;
            int i2 = i(jSONObject);
            View lo = pVar.aeF().lo(i2);
            if (pVar.aeF().ln(i2)) {
                lk = pVar.aeF().lk(i2);
                if (lk) {
                    lk = b(pVar, i2, lo, jSONObject);
                }
            } else {
                lk = false;
            }
            if (lk) {
                pVar.aeF().lp(i2);
            }
            x.i("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[]{Integer.valueOf(jSONObject.optInt("parentId", 0)), Integer.valueOf(i2), Boolean.valueOf(lk)});
            cVar.E(i, e(lk ? "ok" : "fail", null));
        } catch (JSONException e) {
            x.e("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[]{e});
            cVar.E(i, e("fail:view id do not exist", null));
        }
    }

    public boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        return true;
    }
}
