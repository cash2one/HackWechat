package com.tencent.mm.plugin.exdevice.model;

import android.os.Looper;
import com.tencent.mm.g.a.eg;
import com.tencent.mm.plugin.exdevice.model.e.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

class e$40 implements h$a {
    final /* synthetic */ e lLO;

    e$40(e eVar) {
        this.lLO = eVar;
    }

    public final void a(long j, int i, int i2, int i3, long j2) {
        List<b> linkedList;
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "mac=%d, oldState=%d, newState=%d, errCode=%d, profileType=%d", Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2));
        e eVar = this.lLO;
        String cK = com.tencent.mm.plugin.exdevice.j.b.cK(j);
        synchronized (eVar.lKU) {
            linkedList = new LinkedList(eVar.lKU);
        }
        for (b c : linkedList) {
            c.c(cK, i2, j2);
        }
        linkedList.clear();
        for (b c2 : eVar.lKV.values()) {
            c2.c(cK, i2, j2);
        }
        com.tencent.mm.sdk.b.b egVar = new eg();
        egVar.fsU.mac = cK;
        egVar.fsU.fsg = i2;
        egVar.fsU.fsR = j2;
        a.xef.a(egVar, Looper.getMainLooper());
    }
}
