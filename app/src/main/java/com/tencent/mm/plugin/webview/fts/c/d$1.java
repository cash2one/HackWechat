package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class d$1 implements a {
    final /* synthetic */ d trL;

    public d$1(d dVar) {
        this.trL = dVar;
    }

    public final boolean uF() {
        try {
            int ahj = this.trL.trK.tqR.ahj();
            if (Math.abs(ahj - this.trL.jts) >= 250) {
                this.trL.jts = ahj;
                d dVar = this.trL;
                d dVar2 = this.trL;
                d dVar3 = this.trL;
                JSONObject ahm = dVar3.ahm();
                ahm.put("currentTime", dVar3.trK.tqR.ahk());
                dVar.af(dVar2.a(4, ahm));
            }
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e);
        }
        return true;
    }
}
