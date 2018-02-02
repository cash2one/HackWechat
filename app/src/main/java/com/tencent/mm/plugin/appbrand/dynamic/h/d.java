package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public final class d {
    private static Set<String> iUE = new HashSet();

    static {
        CharSequence charSequence = b.NAME;
        if (!TextUtils.isEmpty(charSequence)) {
            iUE.add(charSequence);
        }
    }

    public static boolean qs(String str) {
        return iUE.contains(str);
    }

    public static void a(String str, String str2, JSONObject jSONObject) {
        try {
            jSONObject.put("__session_id", str);
            jSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
            CollectSession qm = c.qm(str);
            if (qm != null) {
                qm.fxd.putInt("__invoke_jsapi_data_size", str2.length());
            }
        } catch (Throwable e) {
            x.e("MicroMsg.JsApiCostTimeStrategy", "%s", new Object[]{Log.getStackTraceString(e)});
        }
    }

    public static String h(JSONObject jSONObject) {
        return jSONObject.optString("__session_id");
    }
}
