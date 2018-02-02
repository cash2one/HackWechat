package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.g.a.jo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$4 extends c<jo> {
    final /* synthetic */ a kus;

    a$4(a aVar) {
        this.kus = aVar;
        this.xen = jo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jo joVar = (jo) bVar;
        if (joVar != null && (joVar instanceof jo)) {
            x.i("MicroMsg.BackupCore", "receive MsgSynchronizeABTestEvent.");
            com.tencent.mm.plugin.w.b.bbL();
            joVar.fAi.fAj = com.tencent.mm.plugin.w.b.oFk;
            joVar.fAi.fAk = com.tencent.mm.plugin.w.b.oFl;
            joVar.fAi.fAl = com.tencent.mm.plugin.w.b.oFm;
        }
        return false;
    }
}
