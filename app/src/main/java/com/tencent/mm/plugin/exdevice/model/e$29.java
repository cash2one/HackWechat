package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.cu;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class e$29 extends c<cu> {
    final /* synthetic */ e lLO;

    e$29(e eVar) {
        this.lLO = eVar;
        this.xen = cu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cu cuVar = (cu) bVar;
        e eVar = this.lLO;
        String str = cuVar.frc.ffq;
        g gVar = eVar.lLK;
        gVar.lMe.remove(str);
        if (gVar.lMk.get(str) != null) {
            x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "cancelWCLanDeviceTask cmdId: " + gVar.lMk.get(str));
            Java2CExDevice.cancelWCLanDeviceTask(((Integer) gVar.lMk.get(str)).intValue());
        }
        return true;
    }
}
