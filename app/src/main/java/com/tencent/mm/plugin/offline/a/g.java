package com.tencent.mm.plugin.offline.a;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g extends h {
    public g(String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("buss_type", str);
        hashMap.put("method", str2);
        String str4 = TencentLocation.NETWORK_PROVIDER;
        Object obj = an.isWifi(ac.getContext()) ? "wifi" : an.is3G(ac.getContext()) ? "3g" : an.is2G(ac.getContext()) ? "2g" : an.isWap(ac.getContext()) ? "wap" : an.is4G(ac.getContext()) ? "4g" : "unknown";
        hashMap.put(str4, obj);
        hashMap.put("transactionid", str3);
        D(hashMap);
    }

    public final int ayQ() {
        return 122;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/datareport";
    }

    public final int Hr() {
        return 1602;
    }
}
