package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r.d;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class r$3 implements Runnable {
    final /* synthetic */ r hHn;
    final /* synthetic */ r$c hHp;

    r$3(r rVar, r$c com_tencent_mm_modelmulti_r_c) {
        this.hHn = rVar;
        this.hHp = com_tencent_mm_modelmulti_r_c;
    }

    public final void run() {
        boolean z = true;
        if (a.Cs() || !g.Dh().Cy()) {
            x.w("MicroMsg.SyncService", "begin to doLoop but MMCore account has not ready or MMCore is hold.");
            return;
        }
        r$c dVar;
        if (this.hHp != null) {
            x.i("MicroMsg.SyncService", "finish proc:%s running:%s RunTime:%s ", new Object[]{this.hHp, r.a(this.hHn), Long.valueOf(bh.bz(r.d(this.hHn)))});
            if (this.hHp != r.a(this.hHn)) {
                for (r$c dVar2 : r.e(this.hHn).keySet()) {
                    x.w("MicroMsg.SyncService", "check unfinish proc :%s timediff:%s", new Object[]{dVar2, Long.valueOf(bh.bz(((Long) r.e(this.hHn).get(dVar2)).longValue()))});
                }
                r.C("oldproc timeout, should in timeoutMap:" + this.hHp, bh.a((Long) r.e(this.hHn).remove(this.hHp), -1) != -1);
                return;
            }
            r.a(this.hHp, r.d(this.hHn));
            r.c(this.hHn, null);
            r.a(this.hHn, 0);
            r.f(this.hHn);
        }
        if (r.a(this.hHn) != null) {
            if (bh.bz(r.d(this.hHn)) > 90000) {
                x.w("MicroMsg.SyncService", "tryStart last proc:%s TIMEOUT:%s Run Next Now.", new Object[]{r.a(this.hHn), Long.valueOf(bh.bz(r.d(this.hHn)))});
                r.d(this.hHn, r.a(this.hHn));
                r.e(this.hHn).put(r.a(this.hHn), Long.valueOf(r.d(this.hHn)));
                r.c(this.hHn, null);
                r.a(this.hHn, 0);
                r.f(this.hHn);
            } else {
                x.i("MicroMsg.SyncService", "tryStart last proc:%s running:%s ", new Object[]{r.a(this.hHn), Long.valueOf(bh.bz(r.d(this.hHn)))});
                return;
            }
        }
        b bVar = (b) g.h(b.class);
        if (bVar.bXT().Ib()) {
            x.w("MicroMsg.SyncService", "Warning: Set SyncService Pause Now.");
            bVar.bXT().HZ();
        } else if (bVar.bXT().Ic()) {
            x.w("MicroMsg.SyncService", "Warning: SyncService is Paused.");
        } else {
            dVar2 = new d(this.hHn);
            if (dVar2.b(null)) {
                r.a(this.hHn, "LightPush");
                r.c(this.hHn, dVar2);
                r.a(this.hHn, bh.Wp());
                return;
            }
            while (!r.b(this.hHn).isEmpty()) {
                dVar2 = (r$c) r.b(this.hHn).poll();
                x.i("MicroMsg.SyncService", "tryStart check NotifyData ListSize:%s proc:%s", new Object[]{Integer.valueOf(r.b(this.hHn).size()), dVar2});
                if (dVar2 != null && dVar2.b(null)) {
                    r.a(this.hHn, "NotifyData");
                    r.c(this.hHn, dVar2);
                    r.a(this.hHn, bh.Wp());
                    return;
                }
            }
            if (!r.c(this.hHn).isEmpty()) {
                dVar2 = (r$c) r.c(this.hHn).poll();
                x.i("MicroMsg.SyncService", "tryStart check Sync ListSize:%s proc:%s", new Object[]{Integer.valueOf(r.c(this.hHn).size()), dVar2});
                if (dVar2 != null && dVar2.b(r.c(this.hHn))) {
                    r.a(this.hHn, "NetSync");
                    r.c(this.hHn, dVar2);
                    r.a(this.hHn, bh.Wp());
                    return;
                }
            }
            x.i("MicroMsg.SyncService", "tryStart FINISH Check running:%s sync:%s notify:%s", new Object[]{r.a(this.hHn), Integer.valueOf(r.c(this.hHn).size()), Integer.valueOf(r.b(this.hHn).size())});
            String str = "";
            if (!(r.a(this.hHn) == null && r.c(this.hHn).isEmpty() && r.b(this.hHn).isEmpty())) {
                z = false;
            }
            r.C(str, z);
        }
    }
}
