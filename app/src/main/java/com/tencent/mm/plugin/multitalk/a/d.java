package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class d {
    public static int oFX = 0;
    public static int oFY = 0;
    public static int oFZ = 0;
    public static int oGa = 0;
    public static int oGb = 0;

    public static final void a(boolean z, long j, String str) {
        int i;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectSuccess %b %d %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str});
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        g.pQN.h(12725, new Object[]{Integer.valueOf(1), Integer.valueOf(i), Long.valueOf(j), str});
    }

    public static final void a(boolean z, long j, String str, int i) {
        int i2;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkConnectFail %b %d %s %d", new Object[]{Boolean.valueOf(z), Long.valueOf(j), str, Integer.valueOf(i)});
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        g.pQN.h(12725, new Object[]{Integer.valueOf(2), Integer.valueOf(i2), Long.valueOf(j), str, Integer.valueOf(i)});
    }

    public static final void bcd() {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailSuccess");
        g.pQN.h(12722, new Object[]{Integer.valueOf(1)});
    }

    public static final void bce() {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkDailFail");
        g.pQN.h(12722, new Object[]{Integer.valueOf(2)});
    }

    public static final void as(int i, String str) {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkReceiveCall %d %s", new Object[]{Integer.valueOf(i), str});
        g.pQN.h(12723, new Object[]{Integer.valueOf(i), str});
    }

    public static final void m(long j, String str) {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMutliTalkDuration %d %s", new Object[]{Long.valueOf(j), str});
        g.pQN.h(12726, new Object[]{Long.valueOf(j), str});
    }

    public static final void a(int i, boolean z, int i2, String str, int i3) {
        int i4;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkSelectContact %d %b %d %s %d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Integer.valueOf(i3)});
        if (z) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        g.pQN.h(12727, new Object[]{Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), str, Integer.valueOf(i3)});
    }

    public static final void n(long j, String str) {
        long j2 = j > 1000 ? j / 1000 : 1;
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkVideoDuration %d %s", new Object[]{Long.valueOf(j2), str});
        g.pQN.h(12728, new Object[]{Long.valueOf(j2), str});
    }

    public static final void Fo(String str) {
        x.v("MicroMsg.MT.MultiTalkKvReportUtil", "reportMultiTalkTalkFunction %s %d %d %d %d %d", new Object[]{str, Integer.valueOf(oFX), Integer.valueOf(oFY), Integer.valueOf(oFZ), Integer.valueOf(oGa), Integer.valueOf(oGb)});
        g.pQN.h(12729, new Object[]{str, Integer.valueOf(oFX), Integer.valueOf(oFY), Integer.valueOf(oFZ), Integer.valueOf(oGa), Integer.valueOf(oGb)});
        cR(9, oFX);
        cR(10, oGb);
        cR(11, oFY);
        cR(12, oFZ);
        cR(13, oGa);
        oFX = 0;
        oFY = 0;
        oFZ = 0;
        oGa = 0;
        oGb = 0;
    }

    public static final void d(String str, boolean z, boolean z2) {
        if (z && z2) {
            g.pQN.h(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(1)});
        } else if (z) {
            g.pQN.h(12917, new Object[]{str, Integer.valueOf(2), Integer.valueOf(2)});
        } else if (z2) {
            g.pQN.h(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(1)});
        } else {
            g.pQN.h(12917, new Object[]{str, Integer.valueOf(1), Integer.valueOf(2)});
        }
    }

    public static final void bcf() {
        g.pQN.a(220, 0, 1, false);
    }

    public static final void gP(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(3);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(4);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g.pQN.a(arrayList, false);
    }

    public static final void bcg() {
        g.pQN.a(220, 1, 1, false);
    }

    public static final void gQ(boolean z) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(5);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        if (z) {
            iDKey = new IDKey();
            iDKey.SetID(220);
            iDKey.SetKey(6);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
        }
        g.pQN.a(arrayList, false);
    }

    public static final void te(int i) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(7);
        iDKey.SetValue((long) i);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(220);
        iDKey.SetKey(8);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        g.pQN.a(arrayList, false);
    }

    private static void cR(int i, int i2) {
        g.pQN.a(220, (long) i, (long) i2, false);
    }

    public static final void bch() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(1)});
    }

    public static final void bci() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(2)});
    }

    public static final void bcj() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(3)});
    }

    public static final void bck() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(4)});
    }

    public static final void bcl() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(5)});
    }

    public static final void bcm() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(6)});
    }

    public static final void bcn() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(7)});
    }

    public static final void bco() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(8)});
    }

    public static final void bcp() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(9)});
    }

    public static final void bcq() {
        g.pQN.h(14849, new Object[]{Integer.valueOf(10)});
    }
}
