package com.tencent.mm.modelmulti;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.r.b;
import com.tencent.mm.modelmulti.r.c;
import com.tencent.mm.protocal.c.atj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;

class r$a {
    int hFo;
    final /* synthetic */ r hHn;
    boolean hHq;
    atj hHr;
    b hHs;
    c hHt;
    ak hHu;

    private r$a(r rVar, c cVar, boolean z, atj com_tencent_mm_protocal_c_atj, b bVar) {
        this.hHn = rVar;
        this.hFo = 0;
        this.hHq = false;
        this.hHr = null;
        this.hHs = null;
        this.hHu = new ak(g.Dm().oAt.getLooper(), new 1(this), true);
        this.hHs = bVar;
        this.hHt = cVar;
        this.hHq = z;
        this.hHr = com_tencent_mm_protocal_c_atj;
        this.hFo = 0;
        String str = "";
        boolean z2 = (this.hHs == null || this.hHt == null) ? false : true;
        r.C(str, z2);
        if (this.hHr == null) {
            r.C("resp Not null", false);
            x.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", new Object[]{this.hHt});
            this.hHs.ie(0);
            return;
        }
        if (g.Dh().Cy() && !a.Cs()) {
            g.Dk();
            if (g.Dj() != null) {
                g.Dk();
                if (g.Dj().CU() != null) {
                    r.a(rVar, com_tencent_mm_protocal_c_atj);
                    long j = (long) com_tencent_mm_protocal_c_atj.wBx;
                    if (String.valueOf(j).length() == 10) {
                        j *= 1000;
                    }
                    long currentTimeMillis = System.currentTimeMillis() - j;
                    long j2 = currentTimeMillis / 1000;
                    x.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Long.valueOf(currentTimeMillis), Long.valueOf(j2)});
                    g.Dk();
                    g.Dj().CU().a(w.a.xuZ, Long.valueOf(currentTimeMillis));
                    g.Dk();
                    g.Dh().aT(this.hHr.ktm, this.hHr.wBw);
                    g.Dk();
                    g.Dh();
                    a.gA(this.hHr.ktm);
                    if (this.hHr.vRD == null || this.hHr.vRD.ksP == null || this.hHr.vRD.ksP.size() <= 0) {
                        x.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", new Object[]{this.hHt});
                        r.a(z, this.hHr, this.hHt);
                        this.hHs.ie(0);
                        return;
                    }
                    x.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", new Object[]{this.hHt, Integer.valueOf(this.hHr.vRD.ksP.size()), Integer.valueOf(this.hHr.ktm), Integer.valueOf(this.hHr.wBw)});
                    this.hHu.J(50, 50);
                    return;
                }
            }
        }
        Object[] objArr = new Object[4];
        objArr[0] = this.hHt;
        objArr[1] = Boolean.valueOf(g.Dh().Cy());
        objArr[2] = Boolean.valueOf(a.Cs());
        g.Dk();
        objArr[3] = g.Dj();
        x.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", objArr);
        this.hHs.ie(0);
    }
}
