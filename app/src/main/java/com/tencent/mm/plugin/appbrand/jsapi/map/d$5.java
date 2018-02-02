package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.compat.a.b$n;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.d.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class d$5 implements b$n {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ d jlZ;
    final /* synthetic */ Map jma;

    d$5(d dVar, Map map, int i, p pVar) {
        this.jlZ = dVar;
        this.jma = map;
        this.jhi = i;
        this.jdJ = pVar;
    }

    public final boolean c(h hVar) {
        c cVar = new c((byte) 0);
        String ou = bh.ou((String) this.jma.get(hVar.getId()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mapId", this.jhi);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, ou);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", e);
        }
        f az = cVar.az(this.jdJ.mAppId, this.jdJ.hashCode());
        az.mData = jSONObject.toString();
        az.afs();
        ou = (String) this.jlZ.jlY.get(hVar.getId());
        if (bh.ov(ou) && bh.ov(hVar.getTitle()) && bh.ov(hVar.getSnippet())) {
            x.e("MicroMsg.JsApiAddMapMarkers", "callout and title and snippet is empty, don't show info window");
            return true;
        } else if (bh.ov(ou)) {
            if (hVar.isInfoWindowShown()) {
                hVar.hideInfoWindow();
            } else {
                hVar.showInfoWindow();
            }
            return true;
        } else if (this.jlZ.d(hVar)) {
            return false;
        } else {
            if (!hVar.isInfoWindowShown()) {
                hVar.showInfoWindow();
            }
            return true;
        }
    }
}
