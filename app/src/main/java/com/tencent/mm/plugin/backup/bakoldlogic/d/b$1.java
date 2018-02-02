package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class b$1 implements Runnable {
    final /* synthetic */ long gyu;
    final /* synthetic */ b$a ksl;
    final /* synthetic */ int ksm = -1;
    final /* synthetic */ b ksn;

    b$1(b bVar, long j, b$a com_tencent_mm_plugin_backup_bakoldlogic_d_b_a, int i) {
        this.ksn = bVar;
        this.gyu = j;
        this.ksl = com_tencent_mm_plugin_backup_bakoldlogic_d_b_a;
    }

    public final void run() {
        g.Dh().Ct();
        x.i("MicroMsg.BakOldTempDbModel", "initTempDB, initTempDBCount:%d  timediff:%d ", new Object[]{Integer.valueOf(b.bl()), Long.valueOf(bh.bz(this.gyu))});
        b.vC();
        ar.Dm().a(new 1(this));
    }
}
