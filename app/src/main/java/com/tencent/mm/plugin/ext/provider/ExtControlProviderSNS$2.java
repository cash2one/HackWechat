package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.g.a.fd;
import com.tencent.mm.pluginsdk.e.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.storage.x;

class ExtControlProviderSNS$2 implements Runnable {
    final /* synthetic */ b kvk;
    final /* synthetic */ x laS;
    final /* synthetic */ ExtControlProviderSNS maR;

    ExtControlProviderSNS$2(ExtControlProviderSNS extControlProviderSNS, x xVar, b bVar) {
        this.maR = extControlProviderSNS;
        this.laS = xVar;
        this.kvk = bVar;
    }

    public final void run() {
        com.tencent.mm.sdk.b.b fdVar = new fd();
        fdVar.fud.type = 1;
        fdVar.fud.username = this.laS.field_username;
        fdVar.fud.fue = ExtControlProviderSNS.a(this.maR);
        fdVar.fud.fuf = ExtControlProviderSNS.b(this.maR);
        fdVar.fud.fug = ExtControlProviderSNS.c(this.maR);
        fdVar.fud.fuh = new 1(this);
        a.xef.m(fdVar);
    }
}
