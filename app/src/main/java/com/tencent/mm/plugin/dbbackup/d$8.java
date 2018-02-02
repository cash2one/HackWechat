package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.a.h;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.k.e;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class d$8 extends c<lu> {
    final /* synthetic */ d lqk;

    d$8(d dVar) {
        this.lqk = dVar;
        this.xen = lu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        e zY = g.zY();
        if (com.tencent.mm.sdk.a.b.ceK()) {
            d.a(this.lqk, true);
            d.a(this.lqk, Long.MAX_VALUE);
        } else {
            int i = zY.getInt("AndroidDBBackupPercentage", 0);
            ar.Hg();
            d.a(this.lqk, h.aJ(com.tencent.mm.z.c.Cg(), 100) < i);
            d.a(this.lqk, (long) zY.getInt("AndroidDBBackupMaxDBSizeMB", 0));
            d.a(this.lqk, d.f(this.lqk) * 1048576);
        }
        d.b(this.lqk, (long) zY.getInt("AndroidDBBackupWaitSeconds", 600));
        d.b(this.lqk, d.g(this.lqk) * 1000);
        String str = "MicroMsg.SubCoreDBBackup";
        String str2 = "Auto backup enabled: %b, max size: %s, debugger: %b";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(d.h(this.lqk));
        objArr[1] = d.f(this.lqk) == Long.MAX_VALUE ? "not limited" : Long.valueOf(d.f(this.lqk));
        objArr[2] = Boolean.valueOf(com.tencent.mm.sdk.a.b.ceK());
        x.d(str, str2, objArr);
        return true;
    }
}
