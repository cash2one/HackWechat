package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.u.b.b$a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public c(int i) {
        super("getNetworkType", i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b$a<JSONObject> com_tencent_mm_u_b_b_a_org_json_JSONObject) {
        Context context = aVar.getContext();
        Map hashMap = new HashMap();
        if (!an.isConnected(context)) {
            hashMap.put("networkType", "none");
        } else if (an.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (an.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (an.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (an.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        com_tencent_mm_u_b_b_a_org_json_JSONObject.aw(a(true, "", hashMap));
    }
}
