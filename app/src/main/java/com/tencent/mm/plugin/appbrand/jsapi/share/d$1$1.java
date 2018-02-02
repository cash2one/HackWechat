package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.share.d.1;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class d$1$1 implements Runnable {
    final /* synthetic */ SendAppMessageTask jqO;
    final /* synthetic */ 1 jqS;

    d$1$1(1 1, SendAppMessageTask sendAppMessageTask) {
        this.jqS = 1;
        this.jqO = sendAppMessageTask;
    }

    public final void run() {
        x.i("MicroMsg.JsApiShareAppMessageDirectly", "task callback");
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
            x.e("MicroMsg.JsApiShareAppMessageDirectly", Log.getStackTraceString(e));
        }
        hashMap.put("shareInfos", jSONArray);
        this.jqS.iZy.E(this.jqS.gOK, this.jqS.jqR.e("ok", hashMap));
    }
}
