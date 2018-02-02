package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.g;
import java.util.ArrayList;

public final class a {
    public static void ks(int i) {
        g.pQN.h(762, (long) i);
    }

    public static void kt(int i) {
        g.pQN.h(762, (long) i);
    }

    public static void bG(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        g.pQN.a(arrayList, true);
    }
}
