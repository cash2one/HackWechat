package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import b.c.b.m;
import b.i;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.s;
import java.util.Collection;
import java.util.List;

public final class c$f implements d {
    final /* synthetic */ c pwG;
    final /* synthetic */ String pwM;
    final /* synthetic */ long pwN;

    c$f(c cVar, String str, long j) {
        this.pwG = cVar;
        this.pwM = str;
        this.pwN = j;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        b bVar;
        if (z) {
            boolean contains;
            a h = g.h(h.class);
            e.h(h, "service(IMessengerStorage::class.java)");
            x WO = ((h) h).EY().WO(str);
            e.h(WO, "contact");
            if (WO.AO() > 0) {
                s.p(WO);
            }
            c.bU(str, 1);
            Iterable<Object> a = c.a(this.pwG);
            e.i(a, "$receiver");
            if (a instanceof Collection) {
                contains = ((Collection) a).contains(str);
            } else {
                int indexOf;
                e.i(a, "$receiver");
                if (a instanceof List) {
                    indexOf = ((List) a).indexOf(str);
                } else {
                    indexOf = 0;
                    for (Object h2 : a) {
                        if (e.h(str, h2)) {
                            break;
                        }
                        indexOf++;
                    }
                    indexOf = -1;
                }
                contains = indexOf >= 0;
            }
            if (contains) {
                Collection a2 = c.a(this.pwG);
                if (a2 == null) {
                    throw new i("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
                m.cC(a2).remove(str);
            }
            bVar = c.pwC;
            com.tencent.mm.sdk.platformtools.x.d(c.access$getTAG$cp(), "addContact %s return ok", this.pwM);
        } else if (z2) {
            if (!(str == null || c.a(this.pwG).contains(str))) {
                c.a(this.pwG).add(str);
            }
            c.bU(str, 2);
            bVar = c.pwC;
            com.tencent.mm.sdk.platformtools.x.d(c.access$getTAG$cp(), "addContact has sent verify to %s", this.pwM);
        } else {
            bVar = c.pwC;
            com.tencent.mm.sdk.platformtools.x.d(c.access$getTAG$cp(), "addContact return not ok, user canceled or error");
        }
        c.a(this.pwG, z, z2, str2, str, this.pwN);
    }
}
