package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    private static f iSa = new f();
    Map<String, b> iSb = new ConcurrentHashMap();
    a iSc = new 1(this);

    public static f acG() {
        return iSa;
    }

    public final boolean au(String str, int i) {
        if (this.iSb.containsKey(str)) {
            return ((b) this.iSb.get(str)).iSf.add(Integer.valueOf(i));
        }
        x.w("MicroMsg.DynamicPageViewStateMonitor", "no keyList exists, widgetId[%s]", new Object[]{str});
        return false;
    }
}
