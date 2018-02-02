package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.s;

public final class c$m implements d {
    final /* synthetic */ c pwG;
    final /* synthetic */ long pwN;
    final /* synthetic */ String pwV;

    public c$m(c cVar, String str, long j) {
        this.pwG = cVar;
        this.pwV = str;
        this.pwN = j;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        boolean z3;
        b bVar;
        if (z) {
            a h = g.h(h.class);
            e.h(h, "service(IMessengerStorage::class.java)");
            x WO = ((h) h).EY().WO(str);
            if (WO == null || WO.AO() == 0) {
                x a = c.a(au.d.Xu(this.pwV));
                h = g.h(h.class);
                e.h(h, "service(IMessengerStorage::class.java)");
                if (!((h) h).EY().R(a)) {
                    bVar = c.pwC;
                    com.tencent.mm.sdk.platformtools.x.e(c.access$getTAG$cp(), "canAddContact fail, insert fail");
                    z = false;
                }
                h = g.h(h.class);
                e.h(h, "service(IMessengerStorage::class.java)");
                WO = ((h) h).EY().WO(a.getUsername());
            }
            b bVar2 = c.pwC;
            com.tencent.mm.sdk.platformtools.x.d(c.access$getTAG$cp(), "verifyContact return ok");
            s.p(WO);
            c.bU(str, 1);
            z3 = z;
        } else {
            bVar = c.pwC;
            com.tencent.mm.sdk.platformtools.x.d(c.access$getTAG$cp(), "verifyContact return not ok");
            z3 = z;
        }
        c.a(this.pwG, z3, str2, str, this.pwN);
    }
}
