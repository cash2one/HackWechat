package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.u.b.c;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends c {
    public d() {
        super("onNetworkStatusChange");
    }

    d(int i) {
        super("onNetworkStatusChange", i);
    }

    public final JSONObject sN() {
        HashMap hashMap = new HashMap();
        Context context = ac.getContext();
        boolean isConnected = an.isConnected(context);
        hashMap.put("isConnected", Boolean.valueOf(isConnected));
        if (!isConnected) {
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
        return new JSONObject(hashMap);
    }
}
