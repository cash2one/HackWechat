package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePlayerView.b;
import com.tencent.mm.plugin.appbrand.jsapi.live.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import org.json.JSONException;
import org.json.JSONObject;

class b$6 implements b {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ b jkW;

    b$6(b bVar, int i, p pVar) {
        this.jkW = bVar;
        this.jhi = i;
        this.jdJ = pVar;
    }

    public final void e(boolean z, int i) {
        a aVar = new a((byte) 0);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fullScreen", z);
            jSONObject.put(TencentLocation.EXTRA_DIRECTION, i);
            jSONObject.put("livePlayerId", this.jhi);
        } catch (JSONException e) {
        }
        f az = aVar.az(this.jdJ.mAppId, this.jdJ.hashCode());
        az.mData = jSONObject.toString();
        az.afs();
    }
}
