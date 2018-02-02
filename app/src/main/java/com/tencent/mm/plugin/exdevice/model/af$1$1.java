package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.tl;
import com.tencent.mm.plugin.exdevice.model.af.1;
import com.tencent.mm.plugin.exdevice.model.i.a;
import com.tencent.mm.sdk.platformtools.x;

class af$1$1 implements a {
    final /* synthetic */ tl lOb;
    final /* synthetic */ 1 lOc;

    af$1$1(1 1, tl tlVar) {
        this.lOc = 1;
        this.lOb = tlVar;
    }

    public final void eH(boolean z) {
        if (z) {
            af.ah(this.lOb.fMa.ffq, true);
            return;
        }
        x.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", new Object[]{this.lOb.fMa.ffq, this.lOb.fMa.frg});
        af.ah(this.lOb.fMa.ffq, false);
    }
}
