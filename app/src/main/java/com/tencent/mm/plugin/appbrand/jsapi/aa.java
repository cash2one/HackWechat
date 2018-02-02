package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.an;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class aa extends a {
    public static final int CTRL_INDEX = 39;
    public static final String NAME = "getNetworkType";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        Map hashMap = new HashMap();
        if (!an.isConnected(jVar.getContext())) {
            hashMap.put("networkType", "none");
        } else if (an.is2G(jVar.getContext())) {
            hashMap.put("networkType", "2g");
        } else if (an.is3G(jVar.getContext())) {
            hashMap.put("networkType", "3g");
        } else if (an.is4G(jVar.getContext())) {
            hashMap.put("networkType", "4g");
        } else if (an.isWifi(jVar.getContext())) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        jVar.E(i, e("ok", hashMap));
    }
}
