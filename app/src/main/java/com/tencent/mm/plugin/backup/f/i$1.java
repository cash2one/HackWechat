package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a {
    final /* synthetic */ i kpB;

    i$1(i iVar) {
        this.kpB = iVar;
    }

    public final boolean uF() {
        long j = 0;
        long bz = bh.bz(i.a(this.kpB));
        if (bz != 0) {
            i.a(this.kpB, (i.b(this.kpB) / bz) * 1000);
            i.d(this.kpB).offer(Long.valueOf(i.c(this.kpB)));
            try {
                bz = ((Long) i.d(this.kpB).poll()).longValue();
            } catch (Exception e) {
                bz = 0;
            }
            i.a(this.kpB, (((i.e(this.kpB) * 10) - bz) + i.c(this.kpB)) / 10);
            i iVar = this.kpB;
            if (i.c(this.kpB) > 0) {
                j = i.c(this.kpB);
            }
            i.a(iVar, j);
            i.b(this.kpB, i.c(this.kpB));
            i.f(this.kpB);
            i.c(this.kpB, bh.Wp());
            i.g(this.kpB).apd();
            if (i.c(this.kpB) < 2) {
                if (i.h(this.kpB) == 0) {
                    i.a(this.kpB, 1);
                    i.g(this.kpB).mE(1);
                    i.d(this.kpB, bh.Wp());
                    x.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is low speed! backupLowSpeedStartTime[%d]", new Object[]{Long.valueOf(i.i(this.kpB))});
                } else if (i.h(this.kpB) == 1 && bh.bz(i.i(this.kpB)) > ((long) i.Uz())) {
                    x.e("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler low speed overtime, overtime[%d]", new Object[]{Long.valueOf(bh.bz(i.i(this.kpB)))});
                    i.a(this.kpB, 2);
                    i.g(this.kpB).ape();
                }
            } else if (i.h(this.kpB) != 0) {
                i.a(this.kpB, 0);
                i.g(this.kpB).mE(0);
                x.i("MicroMsg.BackupSpeedCalculator", "backupGetSpeedTimeHandler is not low speed now.");
            }
        }
        return true;
    }
}
