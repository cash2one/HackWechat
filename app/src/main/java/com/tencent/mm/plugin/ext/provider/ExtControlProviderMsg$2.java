package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;

class ExtControlProviderMsg$2 implements Runnable {
    final /* synthetic */ String[] gIP;
    final /* synthetic */ b kvk;
    final /* synthetic */ x maA;
    final /* synthetic */ ExtControlProviderMsg maz;

    ExtControlProviderMsg$2(ExtControlProviderMsg extControlProviderMsg, x xVar, String[] strArr, b bVar) {
        this.maz = extControlProviderMsg;
        this.maA = xVar;
        this.gIP = strArr;
        this.kvk = bVar;
    }

    public final void run() {
        com.tencent.mm.sdk.b.b exVar = new ex();
        exVar.ftO.toUserName = this.maA.field_username;
        exVar.ftO.content = this.gIP[1];
        exVar.ftO.type = s.hp(this.maA.field_username);
        exVar.ftO.flags = 0;
        if (a.xef.m(exVar)) {
            k kVar = exVar.ftP.ftQ;
            try {
                ar.CG().a(522, new 1(this, com.tencent.mm.plugin.ext.a.a.cO(exVar.ftP.fqm)));
                ar.CG().a(kVar, 0);
                return;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                this.maz.pp(4);
                this.kvk.countDown();
                return;
            }
        }
        this.maz.pp(4);
        this.kvk.countDown();
    }
}
