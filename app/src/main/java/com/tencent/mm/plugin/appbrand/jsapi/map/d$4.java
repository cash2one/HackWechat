package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.compat.a.b$l;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.i.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class d$4 implements b$l {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ d jlZ;
    final /* synthetic */ Map jmb;

    d$4(d dVar, Map map, int i, p pVar) {
        this.jlZ = dVar;
        this.jmb = map;
        this.jhi = i;
        this.jdJ = pVar;
    }

    public final void abJ() {
        if (this.jmb == null) {
            x.e("MicroMsg.JsApiAddMapMarkers", "markerMap is null, return");
            return;
        }
        c cVar = new c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mapId", this.jhi);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", new Object[]{e});
        }
        f a = cVar.a(this.jdJ);
        a.mData = jSONObject.toString();
        a.afs();
        for (h hVar : this.jmb.values()) {
            if (!this.jlZ.d(hVar) && hVar.isInfoWindowShown()) {
                hVar.hideInfoWindow();
            }
        }
    }
}
