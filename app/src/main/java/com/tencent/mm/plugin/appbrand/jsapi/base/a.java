package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.u.b;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a extends d {
    public abstract View a(p pVar, JSONObject jSONObject);

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        p b = b(jVar);
        if (b == null) {
            x.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi insertView failed, current page view is null.");
            jVar.E(i, e("fail:page is null", null));
            return;
        }
        a((c) jVar, i, b, jSONObject);
    }

    public void a(p pVar, JSONObject jSONObject, int i) {
        super.a(pVar, jSONObject, i);
        a((c) pVar, i, pVar, jSONObject);
    }

    private void a(c cVar, int i, p pVar, JSONObject jSONObject) {
        final p pVar2 = pVar;
        final c cVar2 = cVar;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        ag.y(new Runnable(this) {
            final /* synthetic */ a jhh;

            public final void run() {
                if (pVar2 == null) {
                    x.w("MicroMsg.BaseInsertViewJsApi", "page view has been release.");
                    cVar2.E(i2, this.jhh.e("fail:page is null", null));
                    return;
                }
                View a = this.jhh.a(pVar2, jSONObject2);
                if (a == null) {
                    x.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                    cVar2.E(i2, this.jhh.e("inflate view failed", null));
                    return;
                }
                try {
                    int i = this.jhh.i(jSONObject2);
                    if (pVar2.aeF().ln(i)) {
                        x.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[]{Integer.valueOf(i)});
                        cVar2.E(i2, this.jhh.e("fail:the view has already exist", null));
                        return;
                    }
                    boolean a2;
                    b y;
                    String str;
                    int optInt = jSONObject2.optInt("parentId", 0);
                    try {
                        float[] j = a.j(jSONObject2);
                        int k = a.k(jSONObject2);
                        Boolean l = a.l(jSONObject2);
                        u aeF = pVar2.aeF();
                        boolean z = l != null && l.booleanValue();
                        a2 = aeF.a(a, i, optInt, j, k, z);
                    } catch (JSONException e) {
                        x.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[]{e});
                        a2 = false;
                    }
                    if (a2) {
                        a aVar = this.jhh;
                        p pVar = pVar2;
                        JSONObject jSONObject = jSONObject2;
                        if (aVar.afL()) {
                            y = pVar.aeF().y(i, true);
                            y.u("disableScroll", jSONObject.optBoolean("disableScroll", false));
                            y.u("enableLongClick", aVar.afM());
                            y.O(SlookAirButtonFrequentContactAdapter.DATA, jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA));
                            if (jSONObject.optBoolean("gesture", false)) {
                                if (pVar == null || a == null || y == null) {
                                    x.i("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
                                } else {
                                    a.setOnTouchListener(new com.tencent.mm.plugin.appbrand.jsapi.m.b.a(pVar, y));
                                }
                            }
                        }
                        this.jhh.a(pVar2, i, a, jSONObject2);
                    }
                    a aVar2 = this.jhh;
                    p pVar2 = pVar2;
                    y = pVar2.aeF().y(i, true);
                    if (((e) y.get("baseViewDestroyListener", null)) == null) {
                        e 2 = new 2(aVar2, pVar2, i, y);
                        y.o("baseViewDestroyListener", 2);
                        pVar2.a(2);
                    }
                    x.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[]{Integer.valueOf(optInt), Integer.valueOf(i), Integer.valueOf(a.hashCode()), Boolean.valueOf(a2)});
                    c cVar = cVar2;
                    i = i2;
                    com.tencent.mm.plugin.appbrand.jsapi.e eVar = this.jhh;
                    if (a2) {
                        str = "ok";
                    } else {
                        str = "fail:insert view fail";
                    }
                    cVar.E(i, eVar.e(str, null));
                } catch (JSONException e2) {
                    cVar2.E(i2, this.jhh.e("fail:invalid view id", null));
                }
            }
        });
    }

    public void a(p pVar, int i, View view, JSONObject jSONObject) {
    }

    public boolean afL() {
        return false;
    }

    public boolean afM() {
        return false;
    }
}
