package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.2;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements Runnable {
    final /* synthetic */ d kqR;

    d$1(d dVar) {
        this.kqR = dVar;
    }

    public final void run() {
        d dVar = this.kqR;
        dVar.kqQ = 0;
        dVar.kqL = new 2(dVar);
        b.a(5, dVar.kqL);
        String str = (String) com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().CU().get(2, null);
        for (String str2 : dVar.kqI) {
            aj WY = com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().aqK().Fd().WY(str2);
            x.i("MicroMsg.BakPCServer", "backupImp convName:%s, unReadCount:%d", new Object[]{str2, Integer.valueOf(WY != null ? WY.field_unReadCount : 0)});
            if (!dVar.l(str2, str, WY != null ? WY.field_unReadCount : 0)) {
                x.i("MicroMsg.BakPCServer", "backupImp.backupChatMsg canceled");
                return;
            }
        }
        dVar.kqM = true;
        x.i("MicroMsg.BakPCServer", "send conplete waiting to send finishCmd");
        dVar.aqs();
    }
}
