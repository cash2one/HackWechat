package com.tencent.mm.plugin.webview.fts.c;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class d implements a {
    public ak jtr;
    public int jts;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.d tlx;
    private b$b trA;
    FtsWebVideoView trK;

    public d(FtsWebVideoView ftsWebVideoView, b$b com_tencent_mm_plugin_webview_fts_c_b_b, com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
        this.trK = ftsWebVideoView;
        this.trA = com_tencent_mm_plugin_webview_fts_c_b_b;
        this.trA.a(this);
        this.tlx = dVar;
    }

    public final void clean() {
        x.i("MicroMsg.JsApiVideoCallback", "clean %s", new Object[]{toString()});
        ahn();
    }

    public final void af(JSONObject jSONObject) {
        this.tlx.a("onVideoPlayerCallback", null, jSONObject);
    }

    public final void bQy() {
        try {
            JSONObject ahm = ahm();
            ahm.put("currentTime", this.trK.tqR.ahk());
            af(a(6, ahm));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
        }
    }

    public final JSONObject ahm() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, this.trK.jsv);
        return jSONObject;
    }

    public final void ahn() {
        if (this.jtr != null) {
            this.jtr.TG();
        }
    }

    public final void aga() {
    }

    public final void afA() {
    }

    public final void onDestroy() {
        x.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.trK.trc = null;
    }

    public final void agt() {
    }

    public final boolean aeG() {
        return false;
    }

    public final void bPX() {
    }

    public final void bQw() {
    }

    public final JSONObject a(int i, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("playerId", this.trK.jsw);
        jSONObject2.put("event", i);
        if (jSONObject != null) {
            jSONObject2.put("detail", jSONObject);
        }
        return jSONObject2;
    }
}
