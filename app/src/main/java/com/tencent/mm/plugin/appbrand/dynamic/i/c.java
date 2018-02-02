package com.tencent.mm.plugin.appbrand.dynamic.i;

import android.text.TextUtils;
import com.tencent.mm.plugin.report.service.g;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class c implements a {
    private String appId;
    private String iRN;
    private String iUN;
    private Map<String, Integer> iUO = new HashMap();

    public c(String str, String str2) {
        this.appId = str;
        this.iRN = str2;
        this.iUN = this.iRN + "-" + this.appId;
    }

    public final void rw(String str) {
        if (!TextUtils.isEmpty(str)) {
            Integer num = (Integer) this.iUO.get(str);
            if (num == null) {
                num = Integer.valueOf(0);
            }
            this.iUO.put(str, Integer.valueOf(num.intValue() + 1));
        }
    }

    public final void wW() {
        for (Entry entry : this.iUO.entrySet()) {
            g.pQN.h(14705, new Object[]{entry.getKey(), entry.getValue(), this.iUN, this.iRN, this.appId});
        }
        this.iUO.clear();
    }
}
