package com.tencent.mm.plugin.comm;

import com.tencent.mm.ipcinvoker.wx_extension.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.b.b;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.zero.tasks.c;
import com.tencent.mm.r.h;

public class PluginComm extends f implements a {
    public void configure(g gVar) {
        if (gVar.DS()) {
            new c().after((n) com.tencent.mm.kernel.g.k(n.class)).before(this);
        }
    }

    public void execute(g gVar) {
        if (gVar.DS()) {
            pin(com.tencent.mm.plugin.f.a.aod());
            pin(com.tencent.mm.plugin.a.Wy());
            pin(com.tencent.mm.plugin.j.a.axt());
            pin(com.tencent.mm.plugin.l.a.azP());
            pin(com.tencent.mm.plugin.b.a.Xl());
            pin(b.Xm());
            pin(com.tencent.mm.plugin.n.c.aSM());
            pin(com.tencent.mm.plugin.n.b.aSL());
            pin(h.Bj());
            pin(com.tencent.mm.plugin.z.a.biL());
            pin(com.tencent.mm.plugin.r.b.aZg());
            pin(com.tencent.mm.plugin.d.a.XW());
            pin(com.tencent.mm.plugin.y.a.bik());
            pin(com.tencent.mm.plugin.x.a.bfl());
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.r.a.a.class, new com.tencent.mm.plugin.r.a());
            ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(com.tencent.mm.plugin.j.a.axt());
            com.tencent.mm.ui.e.a.a.a(new 1(this));
        }
        pin(e.a.BC());
    }
}
