package com.tencent.mm.z;

import com.tencent.mm.by.h;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.a;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.l;
import com.tencent.mm.storage.n;
import com.tencent.mm.z.b.d;
import java.util.HashMap;

class ar$a implements b, a, c, e, com.tencent.mm.kernel.c.a {
    final /* synthetic */ ar hgf;

    ar$a(ar arVar) {
        this.hgf = arVar;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        if (cVar.gQA) {
            com.tencent.mm.s.c.Bq().o(262145, false);
        }
        g.pQN.a(598, 13, 1, false);
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized start tid[%d]", Long.valueOf(Thread.currentThread().getId()));
        c a = ar.a(this.hgf);
        h hVar = com.tencent.mm.kernel.g.Dj().gQj;
        h hVar2 = com.tencent.mm.kernel.g.Dj().gQk;
        com.tencent.mm.plugin.messenger.foundation.a.a.c aZi = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZi();
        aZi.a(new am(aZi));
        com.tencent.mm.storage.e hVar3 = new com.tencent.mm.storage.h(aZi);
        a.heB = hVar3;
        aZi.a(hVar3);
        a.hez = new bk(hVar, ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).Fd());
        a.heA = new bj(hVar, ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY());
        a.heC = new com.tencent.mm.z.b.c();
        a.heD = new d();
        a.heI = new com.tencent.mm.z.b.b();
        a.heE = new ap(hVar);
        a.heF = new j(hVar);
        a.heG = new n(hVar);
        a.heH = new l(hVar);
        g.pQN.a(598, 14, 1, false);
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done initDB take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        this.hgf.hfV.a(ar.a(this.hgf), cVar.gQA);
        g.pQN.a(598, 15, 1, false);
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done onAccountPostReset take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        c.a aVar = this.hgf.hfV;
        f.ze();
        g.pQN.a(598, 16, 1, false);
        x.i("MicroMsg.MMCore", "summerasyncinit onAccountInitialized done all take[%d]ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public void onAccountRelease() {
    }

    public void parallelsDependency() {
        com.tencent.mm.kernel.a.b.a.a(this, c.class).aJ(com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.messenger.foundation.a.n.class));
    }

    public void onDataBaseOpened(h hVar, h hVar2) {
        c.a aVar = this.hgf.hfV;
        ar.a(this.hgf);
    }

    public void onDataBaseClosed(h hVar, h hVar2) {
    }

    public HashMap<Integer, h.d> collectDatabaseFactory() {
        x.i("MicroMsg.MMCore", "collectDatabaseFactory ");
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.putAll(c.gwY);
        return hashMap;
    }
}
