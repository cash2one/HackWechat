package com.tencent.mm.modelmulti;

import com.tencent.mm.modelmulti.r.c;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Queue;

class r$f implements c {
    int hEY;
    long hHE;
    final /* synthetic */ r hHn;
    atj hHr;

    public r$f(r rVar, b bVar, int i, long j) {
        this.hHn = rVar;
        this.hHr = bVar == null ? null : bVar.vBR;
        this.hHE = j;
        this.hEY = i;
    }

    public final boolean b(Queue<c> queue) {
        if (this.hHr == null) {
            d.pPH.a(99, 40, 1, false);
            x.e("MicroMsg.SyncService", "%s run resp == null", new Object[]{this});
            return false;
        } else if (10018 == r.idt) {
            x.e("MicroMsg.SyncService", "%s Give up for test", new Object[]{this});
            return false;
        } else {
            r$a com_tencent_mm_modelmulti_r_a = new r$a(this.hHn, this, true, this.hHr, new 1(this));
            d.pPH.a(99, 21, 1, false);
            return true;
        }
    }

    public final String toString() {
        return "NotifyData[" + hashCode() + "]";
    }
}
