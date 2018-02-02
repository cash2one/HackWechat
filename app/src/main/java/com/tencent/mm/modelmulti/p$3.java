package com.tencent.mm.modelmulti;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.text.SimpleDateFormat;
import java.util.Date;

class p$3 implements Runnable {
    final /* synthetic */ p hGP;

    p$3(p pVar) {
        this.hGP = pVar;
    }

    public final void run() {
        try {
            ar.Hg();
            int intValue = ((Integer) c.CU().get(a.xsZ, Integer.valueOf(0))).intValue();
            ar.Hg();
            long longValue = ((Long) c.CU().get(a.xsY, Long.valueOf(0))).longValue();
            long q = p.q(this.hGP);
            Object obj = (intValue <= 0 || d.vAz == intValue) ? 1 : null;
            String str = intValue + ";" + d.vAz + ";" + (obj != null ? 1 : 0) + ";" + new SimpleDateFormat("yyyyMMdd").format(new Date(longValue)) + ";" + q;
            g.pQN.a(418, 1, 1, true);
            g.pQN.h(13778, new Object[]{Integer.valueOf(3), Integer.valueOf(1), str});
            x.i("MicroMsg.SubCoreBaseMonitor", "summerreportVersion install result[%s]", new Object[]{str});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreBaseMonitor", e, "reportVersion err!", new Object[0]);
            g.pQN.a(418, 2, 1, true);
        }
    }
}
