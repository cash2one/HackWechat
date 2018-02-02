package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.qy;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$44 extends c<qy> {
    final /* synthetic */ e lLO;

    e$44(e eVar) {
        this.lLO = eVar;
        this.xen = qy.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qy qyVar = (qy) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelWithParamsEvent");
        qyVar = qyVar;
        ad.aEr();
        d.eG(qyVar.fIL.fIM);
        return true;
    }
}
