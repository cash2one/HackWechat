package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;

class b$2$1 implements a {
    final /* synthetic */ 2 ksq;

    b$2$1(2 2) {
        this.ksq = 2;
    }

    public final boolean JC() {
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
        this.ksq.ksp.run();
        com.tencent.mm.sdk.b.a.xef.m(new pe());
        return false;
    }

    public final boolean JB() {
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
        x.cfk();
        b.aqP();
        e.g(new File(com.tencent.mm.plugin.backup.bakoldlogic.a.a.aqi()));
        a aqL = this.ksq.ksn.aqL();
        aqL.handler.post(new Runnable(aqL) {
            final /* synthetic */ a ksf;

            {
                this.ksf = r1;
            }

            public final void run() {
                Iterator it = this.ksf.kpH.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                        String str = (String) aVar.obj;
                        x.d("MicroMsg.BakOldRecoverDelayData", "getContact:" + str);
                        com.tencent.mm.z.ak.a.hfL.Q(str, "");
                    } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                        an.bim().RD((String) aVar.obj);
                    }
                }
                this.ksf.kpH.clear();
            }
        });
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
        x.cfk();
        return true;
    }

    public final String toString() {
        return super.toString() + "|bakoldRecoverFromTempDb";
    }
}
