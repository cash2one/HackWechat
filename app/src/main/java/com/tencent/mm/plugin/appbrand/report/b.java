package com.tencent.mm.plugin.appbrand.report;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class b {
    private static HashMap<String, Integer> jHb = new HashMap();

    public static void aH(String str, int i) {
        x.d("MicroMsg.AppBrandServiceTypeCache", "addServiceTypeMap appId: %s,serviceType:%d", new Object[]{str, Integer.valueOf(i)});
        jHb.put(str, Integer.valueOf(i));
    }

    public static int tY(String str) {
        if (jHb.containsKey(str)) {
            x.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap appId: %s");
            return ((Integer) jHb.get(str)).intValue();
        }
        x.d("MicroMsg.AppBrandServiceTypeCache", "getServiceTypeMap default appId: %s");
        return 0;
    }
}
