package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.du;
import com.tencent.mm.plugin.exdevice.model.e.39;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$23 extends c<du> {
    final /* synthetic */ e lLO;

    e$23(e eVar) {
        this.lLO = eVar;
        this.xen = du.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        du duVar = (du) bVar;
        e eVar = this.lLO;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOpInChattingUIEvent");
        duVar = duVar;
        if (bh.ov(duVar.fss.userName)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceOpInChattingUIEventListener, userName is null");
            return false;
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This biz is binded a device, notify chatting view to dimiss connect fail tips");
        e.bg(duVar.fss.userName, -1);
        if ((duVar.fss.op != 0 && duVar.fss.op != 3) || !i.lMM.eI(false)) {
            return eVar.V(duVar.fss.op, duVar.fss.userName);
        }
        i.lMM.a(duVar.fss.context, new 39(eVar, duVar));
        return true;
    }
}
