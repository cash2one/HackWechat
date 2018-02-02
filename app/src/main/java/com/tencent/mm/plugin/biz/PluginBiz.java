package com.tencent.mm.plugin.biz;

import com.tencent.mm.ag.l;
import com.tencent.mm.ag.o;
import com.tencent.mm.ag.y;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.d;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.z.h;
import com.tencent.mm.z.j;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class PluginBiz extends f implements a, b {
    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(g gVar) {
        if (gVar.DS()) {
            com.tencent.mm.kernel.g.a(o.class, new d(new l()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.biz.a.a.class, new a());
        }
        com.tencent.mm.pluginsdk.ui.applet.n.a.vos = new com.tencent.mm.pluginsdk.ui.applet.d();
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            pin(new p(y.class));
            com.tencent.mm.kernel.g.a(com.tencent.mm.api.f.class, new com.tencent.mm.z.g());
            com.tencent.mm.kernel.g.a(com.tencent.mm.api.g.class, new h());
            com.tencent.mm.kernel.g.a(com.tencent.mm.api.h.class, new j());
        }
    }

    public HashMap<Integer, com.tencent.mm.by.h.d> collectDatabaseFactory() {
        HashMap<Integer, com.tencent.mm.by.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new 1(this));
        return hashMap;
    }
}
