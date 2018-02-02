package com.tencent.mm.plugin.wear.model.c;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class a {
    public static final void ee(int i, int i2) {
        if (com.tencent.mm.plugin.wear.model.a.bOt().thH.thY.tiP != null) {
            x.v("MicroMsg.Wear.ReportKVUtil", "report kv operation=%d scene=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            g.pQN.h(11632, new Object[]{Integer.valueOf(i), r0.ksZ, r0.wYA, Integer.valueOf(i2)});
        }
    }

    public static final void zA(int i) {
        g.pQN.a(249, (long) i, 1, false);
    }

    public static final void kd(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(az.CTRL_INDEX);
        iDKey.SetKey(12);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(az.CTRL_INDEX);
            iDKey.SetKey(13);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g.pQN.a(arrayList, false);
    }
}
