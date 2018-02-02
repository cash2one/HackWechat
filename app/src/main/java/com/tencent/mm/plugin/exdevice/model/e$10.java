package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.ec;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class e$10 extends c<ec> {
    final /* synthetic */ e lLO;

    e$10(e eVar) {
        this.lLO = eVar;
        this.xen = ec.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ec ecVar = (ec) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSetSendDataDirectionEvent: %s, %s, %s", new Object[]{ecVar.fsL.ffq, Integer.valueOf(ecVar.fsL.direction), Boolean.valueOf(ecVar.fsL.clear)});
        if (ecVar.fsL.clear) {
            k.aDL().lKi.clear();
            ecVar.fsM.frp = true;
        } else if (bh.ov(ecVar.fsL.ffq)) {
            ecVar.fsM.frp = false;
        } else {
            k aDL = k.aDL();
            String str = ecVar.fsL.ffq;
            int i = ecVar.fsL.direction;
            if (!bh.ov(str)) {
                aDL.lKi.put(str, Integer.valueOf(i));
            }
            ecVar.fsM.frp = true;
        }
        return true;
    }
}
