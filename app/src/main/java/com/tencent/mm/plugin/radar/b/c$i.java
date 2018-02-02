package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.g.a.md;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.x;

public final class c$i extends c<md> {
    final /* synthetic */ c pwG;

    c$i(c cVar) {
        this.pwG = cVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        md mdVar = (md) bVar;
        e.i(mdVar, "event");
        String str = mdVar.fDN.fDP;
        x a = c.a(d.Xu(str));
        c.a(this.pwG, a);
        c cVar = this.pwG;
        e.h(str, "msgContent");
        c.a(cVar, a, str);
        a h = g.h(h.class);
        e.h(h, "service(IMessengerStorage::class.java)");
        ar EY = ((h) h).EY();
        if (!EY.WQ(a.vS())) {
            EY.Q(a);
        }
        c.b bVar2 = c.pwC;
        com.tencent.mm.sdk.platformtools.x.d(c.access$getTAG$cp(), "receive verify mssage %s, encypt %s", a.getUsername(), a.vS());
        c.b(this.pwG, a);
        return false;
    }
}
