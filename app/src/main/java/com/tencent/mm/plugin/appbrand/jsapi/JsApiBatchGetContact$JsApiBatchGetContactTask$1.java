package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.r.AnonymousClass2;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact.JsApiBatchGetContactTask;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONObject;

class JsApiBatchGetContact$JsApiBatchGetContactTask$1 implements Runnable {
    final /* synthetic */ JsApiBatchGetContactTask jcP;

    JsApiBatchGetContact$JsApiBatchGetContactTask$1(JsApiBatchGetContactTask jsApiBatchGetContactTask) {
        this.jcP = jsApiBatchGetContactTask;
    }

    public final void run() {
        boolean[] zArr = new boolean[]{false};
        Timer timer = new Timer();
        timer.schedule(new 1(this, zArr, timer), 60000);
        try {
            List arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.jcP.jcK.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Pair O = r.O(str, false);
                if (O.second == null) {
                    arrayList.add(str);
                }
                synchronized (JsApiBatchGetContact.class) {
                    if (zArr[0]) {
                        timer.cancel();
                        return;
                    } else if (O.first == null || bh.ov(((WxaAttributes) O.first).field_appInfo)) {
                        zArr[0] = true;
                        JsApiBatchGetContactTask.a(this.jcP, "fail:get contact fail");
                        x.w("MicroMsg.JsApiBatchGetContact", "get contact fail");
                        JsApiBatchGetContactTask.b(this.jcP);
                        timer.cancel();
                        return;
                    } else {
                        JSONObject optJSONObject = new JSONObject(((WxaAttributes) O.first).field_appInfo).optJSONObject("PluginInfo");
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                        }
                        optJSONObject.put("appId", str);
                        jSONArray.put(optJSONObject);
                    }
                }
            }
            if (!bh.cA(arrayList)) {
                x.i("MicroMsg.JsApiBatchGetContact", "needUpdateList size %d", new Object[]{Integer.valueOf(arrayList.size())});
                if (!bh.cA(arrayList)) {
                    e.post(new AnonymousClass2(arrayList), "WxaAttrSync");
                }
            }
            synchronized (JsApiBatchGetContact.class) {
                if (zArr[0]) {
                    timer.cancel();
                    return;
                }
                zArr[0] = true;
                x.i("MicroMsg.JsApiBatchGetContact", "try to stop timer");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("errMsg", "batchGetContact:ok");
                jSONObject.put("contactList", jSONArray);
                JsApiBatchGetContactTask.b(this.jcP, jSONObject.toString());
                JsApiBatchGetContactTask.c(this.jcP);
                timer.cancel();
            }
        } catch (Throwable e) {
            try {
                x.printErrStackTrace("MicroMsg.JsApiBatchGetContact", e, "", new Object[0]);
                JsApiBatchGetContactTask.a(this.jcP, "fail:" + e.getMessage());
                JsApiBatchGetContactTask.d(this.jcP);
            } finally {
                timer.cancel();
            }
        }
    }
}
