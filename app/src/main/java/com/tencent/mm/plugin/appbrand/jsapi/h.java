package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.report.a.f;
import java.util.HashMap;

public final class h {
    final HashMap<Integer, a> jcd = new HashMap();

    h() {
    }

    public final void H(int i, String str) {
        a aVar = (a) this.jcd.remove(Integer.valueOf(i));
        if (aVar != null) {
            f.a(aVar.jce.getAppId(), aVar.path, aVar.jcf.getName(), aVar.data, c.a(aVar.jce, aVar.jcf), System.currentTimeMillis() - aVar.startTime, str);
            this.jcd.remove(Integer.valueOf(i));
        }
    }
}
