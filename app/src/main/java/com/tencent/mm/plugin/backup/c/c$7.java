package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.f.j;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class c$7 implements e {
    final /* synthetic */ c klx;

    c$7(c cVar) {
        this.klx = cVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        b.b(3, c.i(this.klx));
        x.i("MicroMsg.BackupMoveRecoverServer", "backupmove receive startrequest response.[%d,%d,%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            j jVar = (j) kVar;
            o oVar = jVar.kpD;
            if (b.aoR().kiB.equals(oVar.ID)) {
                double d;
                b.aoR().aol().kiM = oVar.kte;
                this.klx.ffq = jVar.kpD.kth.ksX;
                if (jVar.kpD.kth.kta.toLowerCase().contains("ios")) {
                    c.a(this.klx, 1);
                } else {
                    c.a(this.klx, 2);
                }
                c.a(this.klx, jVar.kpD.ktl);
                c.b(this.klx, jVar.kpD.ktn);
                x.i("MicroMsg.BackupMoveRecoverServer", "move recover totalCount[%d], totalSize[%d], and wait old mobile's pushData", new Object[]{Long.valueOf(jVar.kpD.ktk), Long.valueOf(jVar.kpD.ktl)});
                if (c.j(this.klx) && c.g(this.klx)) {
                    g gVar = g.pQN;
                    int i3 = (c.k(this.klx) || c.l(this.klx) == 1) ? 66 : 65;
                    gVar.a(485, (long) i3, 1, false);
                }
                if ((jVar.kpD.ktj == 3 ? 1 : null) != null) {
                    c.c(this.klx, true);
                    x.i("MicroMsg.BackupMoveRecoverServer", "isQuickBackup!!!");
                } else {
                    c.c(this.klx, false);
                }
                PLong pLong = new PLong();
                PLong pLong2 = new PLong();
                ar.Hg();
                com.tencent.mm.plugin.backup.a.g.a(pLong, pLong2, c.FC());
                long m = c.m(this.klx);
                if (((double) c.m(this.klx)) * 0.1d > 5.24288E8d) {
                    d = 5.24288E8d;
                } else {
                    d = ((double) c.m(this.klx)) * 0.1d;
                }
                long j = ((long) d) + m;
                this.klx.kls = j;
                if (pLong2.value < j) {
                    x.e("MicroMsg.BackupMoveRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d, dataSize:%d", new Object[]{Long.valueOf(pLong2.value), Long.valueOf(j), Long.valueOf(c.m(this.klx))});
                    g.pQN.h(11787, new Object[]{Integer.valueOf(5)});
                    b.aoR().aoS().stop();
                    b.aoR().aol().kiJ = -13;
                    this.klx.mz(-13);
                    g.pQN.a(485, 5, 1, false);
                    return;
                }
                c.b(this.klx, bh.Wp());
                return;
            }
            x.e("MicroMsg.BackupMoveRecoverServer", "start response not the same id");
            b.aoR().aol().kiJ = -5;
            this.klx.mz(-5);
            return;
        }
        x.e("MicroMsg.BackupMoveRecoverServer", "start request failed, errMsg:" + str);
        b.aoR().aol().kiJ = -5;
        this.klx.mz(-5);
    }
}
