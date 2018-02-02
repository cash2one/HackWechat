package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.plugin.dbbackup.d.9;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class d$9$2 implements Runnable {
    final /* synthetic */ b lpY;
    final /* synthetic */ boolean lpn;
    final /* synthetic */ 9 lqw;

    d$9$2(9 9, boolean z, b bVar) {
        this.lqw = 9;
        this.lpn = z;
        this.lpY = bVar;
    }

    public final void run() {
        d.a(this.lqw.lqk, null);
        ar.Hg();
        long length = new File(c.CS()).length();
        long cgu = bh.cgu();
        if (length == 0) {
            x.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
        } else if (length > d.f(this.lqw.lqk) || length > cgu) {
            x.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
            g gVar = g.pQN;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(10008);
            objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(cgu)});
            gVar.h(11098, objArr);
        } else {
            d.d(this.lqw.lqk, this.lqw.lqk.a(this.lpn, this.lpY));
            if (d.o(this.lqw.lqk)) {
                x.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
            }
        }
    }
}
