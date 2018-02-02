package com.tencent.mm.app;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.app.WorkerProfile.20;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class WorkerProfile$20$1 implements e {
    final /* synthetic */ 20 fgD;

    WorkerProfile$20$1(20 20) {
        this.fgD = 20;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(1145, this);
        x.i("MicroMsg.WorkerProfile", "onSceneEnd(GetServiceNotifyOptions), errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && kVar.getType() == 1145) {
            l lVar = (l) kVar;
            if ((((afr) lVar.hjD.hmg.hmo).wnA & 1) != 0) {
                boolean z = lVar.Jb().vLB;
                ar.Hg();
                if (z != c.CU().getBoolean(a.xsq, true)) {
                    x.i("MicroMsg.WorkerProfile", "service notify message notice switch changed(to : %b)", new Object[]{Boolean.valueOf(z)});
                    ar.Hg();
                    c.CU().a(a.xsq, Boolean.valueOf(z));
                    com.tencent.mm.sdk.b.a.xef.m(new mx());
                }
                z = lVar.Jb().wnB;
                ar.Hg();
                if (z != c.CU().getBoolean(a.xsr, true)) {
                    x.i("MicroMsg.WorkerProfile", "wxa custom session notify message notice switch changed(to : %b)", new Object[]{Boolean.valueOf(z)});
                    ar.Hg();
                    c.CU().a(a.xsr, Boolean.valueOf(z));
                    com.tencent.mm.sdk.b.a.xef.m(new mx());
                }
            }
        }
    }
}
