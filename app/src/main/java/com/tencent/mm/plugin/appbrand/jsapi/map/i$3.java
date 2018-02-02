package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.compat.a.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.i.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class i$3 implements l {
    final /* synthetic */ p jfB;
    final /* synthetic */ int jhi;
    final /* synthetic */ i jmd;

    i$3(i iVar, int i, p pVar) {
        this.jmd = iVar;
        this.jhi = i;
        this.jfB = pVar;
    }

    public final void abJ() {
        c cVar = new c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mapId", this.jhi);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", new Object[]{e});
        }
        f a = cVar.a(this.jfB);
        a.mData = jSONObject.toString();
        a.afs();
    }
}
