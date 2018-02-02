package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.ef;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$13 extends c<ef> {
    final /* synthetic */ e lLO;

    e$13(e eVar) {
        this.lLO = eVar;
        this.xen = ef.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ef efVar = (ef) bVar;
        e eVar = this.lLO;
        if (efVar == null || !(efVar instanceof ef)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTConnectDeviceEvent");
            return false;
        }
        efVar = efVar;
        if (efVar.fsS.fro ? eVar.yR(efVar.fsS.mac) : e.yQ(efVar.fsS.mac)) {
            efVar.fsT.frp = true;
            return true;
        }
        efVar.fsT.frp = false;
        return true;
    }
}
