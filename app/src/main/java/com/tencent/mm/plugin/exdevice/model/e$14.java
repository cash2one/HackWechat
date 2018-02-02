package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.ek;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$14 extends c<ek> {
    final /* synthetic */ e lLO;

    e$14(e eVar) {
        this.lLO = eVar;
        this.xen = ek.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ek ekVar = (ek) bVar;
        e eVar = this.lLO;
        if (ekVar == null || !(ekVar instanceof ek)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTSendDataToDeviceEvent");
            return false;
        }
        ekVar = ekVar;
        if (eVar.m(ekVar.fsZ.mac, ekVar.fsZ.data)) {
            ekVar.fta.frp = true;
            return true;
        }
        ekVar.fta.frp = false;
        return true;
    }
}
