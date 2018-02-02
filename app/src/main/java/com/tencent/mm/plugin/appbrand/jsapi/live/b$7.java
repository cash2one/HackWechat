package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.TXLiveConstants;
import org.json.JSONException;
import org.json.JSONObject;

class b$7 implements ITXLivePlayListener {
    final /* synthetic */ p jdJ;
    final /* synthetic */ int jhi;
    final /* synthetic */ b jkW;

    b$7(b bVar, int i, p pVar) {
        this.jkW = bVar;
        this.jhi = i;
        this.jdJ = pVar;
    }

    public final void onPlayEvent(int i, Bundle bundle) {
        x.i("MicroMsg.JsApiInsertLivePlayer", "onPlayEvent errCode:%d", Integer.valueOf(i));
        b$c com_tencent_mm_plugin_appbrand_jsapi_live_b_c = new b$c();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errCode", i);
            jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
            jSONObject.put("livePlayerId", this.jhi);
        } catch (JSONException e) {
        }
        f az = com_tencent_mm_plugin_appbrand_jsapi_live_b_c.az(this.jdJ.mAppId, this.jdJ.hashCode());
        az.mData = jSONObject.toString();
        az.afs();
    }

    public final void onNetStatus(Bundle bundle) {
        b$b com_tencent_mm_plugin_appbrand_jsapi_live_b_b = new b$b();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("livePlayerId", this.jhi);
            JSONObject jSONObject2 = new JSONObject();
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    jSONObject2.put(str, bundle.get(str));
                }
            }
            jSONObject.put("info", jSONObject2);
        } catch (JSONException e) {
        }
        f az = com_tencent_mm_plugin_appbrand_jsapi_live_b_b.az(this.jdJ.mAppId, this.jdJ.hashCode());
        az.mData = jSONObject.toString();
        az.afs();
    }
}
