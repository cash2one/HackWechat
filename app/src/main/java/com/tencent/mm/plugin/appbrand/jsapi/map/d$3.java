package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.d.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class d$3 implements j {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ d jlZ;
    final /* synthetic */ Map jma;

    d$3(d dVar, Map map, int i, p pVar) {
        this.jlZ = dVar;
        this.jma = map;
        this.jhi = i;
        this.jdJ = pVar;
    }

    public final void b(h hVar) {
        b bVar = new b((byte) 0);
        String ou = bh.ou((String) this.jma.get(hVar.getId()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mapId", this.jhi);
            jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, ou);
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiAddMapMarkers", "put JSON data error : %s", e);
        }
        f az = bVar.az(this.jdJ.mAppId, this.jdJ.hashCode());
        az.mData = jSONObject.toString();
        az.afs();
    }
}
