package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.v.g;
import java.util.ArrayList;

public final class b {
    private static a iUI = new a((byte) 0);
    private static a iUJ = new a((byte) 0);

    public static void f(long j, int i) {
        if (j > 0 && i > 0) {
            switch (g.Cf()) {
                case 1:
                    a(iUJ, j, i);
                    return;
                default:
                    a(iUI, j, i);
                    return;
            }
        }
    }

    public static void adk() {
        a(5, 6, 7, 8, iUJ);
        a(0, 1, 2, 3, iUI);
        iUJ.reset();
        iUI.reset();
    }

    private static void a(a aVar, long j, int i) {
        synchronized (aVar) {
            aVar.iUK += j / 1000;
            aVar.iUL += (long) i;
            aVar.iUM += j / ((long) i);
            aVar.count++;
        }
    }

    private static void a(int i, int i2, int i3, int i4, a aVar) {
        int i5 = aVar.count;
        long j = aVar.iUK;
        long j2 = aVar.iUL;
        long j3 = aVar.iUM;
        if (j > 0 && j2 > 0 && i5 > 0 && j3 > 0) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(690);
            iDKey.SetKey(i);
            iDKey.SetValue(j);
            arrayList.add(iDKey);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(690);
            iDKey2.SetKey(i2);
            iDKey2.SetValue(j2);
            arrayList.add(iDKey2);
            iDKey2 = new IDKey();
            iDKey2.SetID(690);
            iDKey2.SetKey(i3);
            iDKey2.SetValue((long) i5);
            arrayList.add(iDKey2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(690);
            iDKey3.SetKey(i4);
            iDKey3.SetValue(j3);
            arrayList.add(iDKey3);
            com.tencent.mm.plugin.report.service.g.pQN.a(arrayList, false);
        }
    }
}
