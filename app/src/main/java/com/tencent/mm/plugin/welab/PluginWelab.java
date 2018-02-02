package com.tencent.mm.plugin.welab;

import com.tencent.mm.by.h;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.auth.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class PluginWelab extends f implements a, c, d, com.tencent.mm.plugin.welab.a.a {
    private c tOV = new c();
    private boolean tOW;

    public void installed() {
        alias(com.tencent.mm.plugin.welab.a.a.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(g gVar) {
        if (gVar.DS()) {
            x.v("PluginWelab", "configure");
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.d.class, new com.tencent.mm.kernel.c.d(new d()));
            ((b) com.tencent.mm.kernel.g.k(b.class)).addHandleAuthResponse(new 1(this));
        }
    }

    public void execute(g gVar) {
        x.v("PluginWelab", "execute");
    }

    public String toString() {
        return "plugin-welab";
    }

    public void onDataBaseOpened(h hVar, h hVar2) {
        x.v("PluginWelab", "onDataBaseOpened");
        b.bVu().tPx = new com.tencent.mm.plugin.welab.c.a(hVar);
    }

    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    public void onAccountInitialized(e.c cVar) {
        x.v("PluginWelab", "onAccountInitialized");
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.a.class, new com.tencent.mm.plugin.welab.a.b());
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.welab.a.a.c.class, new com.tencent.mm.plugin.welab.a.c());
        this.tOW = cVar.gQA;
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().a("newabtestlabs", this.tOV, true);
    }

    public void onAccountRelease() {
        x.v("PluginWelab", "onAccountRelease");
        ((n) com.tencent.mm.kernel.g.k(n.class)).getSysCmdMsgExtension().b("newabtestlabs", this.tOV, true);
    }

    public HashMap<Integer, h.d> collectDatabaseFactory() {
        x.v("PluginWelab", "collectDatabaseFactory");
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("LabAppInfo".hashCode()), new 2(this));
        return hashMap;
    }
}
