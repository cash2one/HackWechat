package com.tencent.mm.pluginsdk.h;

import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class l {
    public static l vfS = new l("default");
    private boolean mAK = false;
    private ConcurrentHashMap<String, Integer> vfP = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Long> vfQ = new ConcurrentHashMap();
    private String vfR = "";

    public l(String str) {
        if (b.ceK()) {
            this.mAK = true;
        }
        this.vfR = str;
    }

    public final void RO(String str) {
        if (this.mAK) {
            int intValue;
            long longValue;
            if (this.vfP.containsKey(str)) {
                intValue = ((Integer) this.vfP.get(str)).intValue();
            } else {
                intValue = 0;
            }
            int i = intValue + 1;
            this.vfP.put(str, Integer.valueOf(i));
            if (this.vfQ.containsKey(str)) {
                longValue = ((Long) this.vfQ.get(str)).longValue();
            } else {
                longValue = 0;
            }
            if (System.currentTimeMillis() - longValue > 1000) {
                new StringBuilder().append(this.vfR).append("user get fps ").append(i).append(" fpswraper: ").append(str);
                this.vfP.put(str, Integer.valueOf(0));
                this.vfQ.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
