package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.share.c.1;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class c$1$1 implements Runnable {
    final /* synthetic */ String fgO;
    final /* synthetic */ SendAppMessageTask jqO;
    final /* synthetic */ int jqP;
    final /* synthetic */ 1 jqQ;

    c$1$1(1 1, SendAppMessageTask sendAppMessageTask, String str, int i) {
        this.jqQ = 1;
        this.jqO = sendAppMessageTask;
        this.fgO = str;
        this.jqP = i;
    }

    public final void run() {
        x.i("MicroMsg.JsApiShareAppMessage", "task callback");
        this.jqO.afj();
        Map hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        try {
            if (!bh.cA(this.jqO.jrf)) {
                Iterator it = this.jqO.jrf.iterator();
                while (it.hasNext()) {
                    ShareInfo shareInfo = (ShareInfo) it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("shareKey", shareInfo.hjA);
                    jSONObject.put("shareName", shareInfo.hjz);
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(e));
        }
        hashMap.put("shareInfos", jSONArray);
        this.jqQ.iZy.E(this.jqQ.gOK, this.jqQ.jqN.e("ok", hashMap));
        int i = 16;
        String str = this.fgO + ":";
        if (this.fgO.toLowerCase().endsWith("@chatroom")) {
            i = 15;
        }
        c.a(this.jqQ.fgU, this.jqQ.jqE, i, str, 1, this.jqP);
    }
}
