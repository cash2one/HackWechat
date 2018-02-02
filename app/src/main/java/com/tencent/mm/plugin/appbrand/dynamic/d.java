package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {
    private static volatile d iRW;
    Map<String, c> iRX = new ConcurrentHashMap();

    private d() {
    }

    public static d acE() {
        if (iRW == null) {
            synchronized (d.class) {
                if (iRW == null) {
                    iRW = new d();
                }
            }
        }
        return iRW;
    }

    public final c rm(String str) {
        if (!bh.ov(str)) {
            return (c) this.iRX.get(str);
        }
        x.w("MicroMsg.DynamicPageViewIPCProxyManager", "get IPCProxy from manager failed, key is null or nil.");
        return null;
    }
}
