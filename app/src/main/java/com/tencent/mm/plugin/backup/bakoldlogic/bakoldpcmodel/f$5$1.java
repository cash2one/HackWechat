package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5;
import com.tencent.mm.plugin.backup.bakoldlogic.c.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.Iterator;

class f$5$1 implements Runnable {
    final /* synthetic */ 5 kru;

    f$5$1(5 5) {
        this.kru = 5;
    }

    public final void run() {
        x.i("MicroMsg.RecoverPCServer", "readFromSdcard end");
        x.cfk();
        a.aql().aqm().krd = 7;
        this.kru.krr.krm = 0;
        if (this.kru.krr.kqK != null) {
            this.kru.krr.kqK.aok();
        } else {
            x.i("MicroMsg.RecoverPCServer", "operatorCallback is null");
        }
        e.aqx();
        new b(8).apQ();
        x.i("MicroMsg.RecoverPCServer", "recover ok");
        ar.Hg();
        c.CU().a(a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(true));
        c aqn = a.aql().aqn();
        aqn.kqG++;
        a.aql().aqm().krc = 7;
        this.kru.krr.cancel();
        com.tencent.mm.plugin.backup.bakoldlogic.d.a aqL = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqL();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = aqL.kpH.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.backup.bakoldlogic.d.a.a aVar = (com.tencent.mm.plugin.backup.bakoldlogic.d.a.a) it.next();
            if (aVar.type == 2 && aVar.obj != null && (aVar.obj instanceof String)) {
                stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
            } else if (aVar.type == 1 && aVar.obj != null && (aVar.obj instanceof String)) {
                stringBuffer.append(aVar.type + " : " + ((String) aVar.obj) + " ,");
            }
        }
        x.d("MicroMsg.BakOldRecoverDelayData", "dump delay " + stringBuffer.toString());
    }
}
