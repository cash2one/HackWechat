package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.config.a$f;
import com.tencent.mm.plugin.appbrand.config.a.e;
import com.tencent.mm.plugin.appbrand.page.e.a;
import com.tencent.mm.plugin.appbrand.widget.c.b;
import java.util.HashMap;
import java.util.Map;

class e$1 implements b {
    final /* synthetic */ e jDa;
    final /* synthetic */ e jDb;

    e$1(e eVar, e eVar2) {
        this.jDb = eVar;
        this.jDa = eVar2;
    }

    public final void L(int i, String str) {
        this.jDb.iqC.tF(str);
        Map hashMap = new HashMap();
        hashMap.put("pagePath", str);
        hashMap.put("text", ((a$f) this.jDa.fBU.get(i)).text);
        hashMap.put("index", Integer.valueOf(i));
        new a((byte) 0).a(this.jDb.aex()).v(hashMap).afs();
    }
}
