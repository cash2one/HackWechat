package com.tencent.mm.ipcinvoker;

import java.util.HashMap;
import java.util.Map;

public class k {
    private static volatile k gMG;
    Map<String, BaseIPCService> gMH = new HashMap();

    private k() {
    }

    public static k Bv() {
        if (gMG == null) {
            synchronized (k.class) {
                if (gMG == null) {
                    gMG = new k();
                }
            }
        }
        return gMG;
    }

    public final BaseIPCService fl(String str) {
        return (BaseIPCService) this.gMH.get(str);
    }
}
