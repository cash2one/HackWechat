package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.i.a.b.i.b;
import com.tencent.mm.sdk.platformtools.bh;

public final class j {
    private static final int vhb = b.vgX.fDt;
    private static final int vhc = b.vgZ.fDt;
    private static final int vhd = b.vgY.fDt;

    public static void I(long j, long j2) {
        if (j > 0 && 197 != j) {
            g.pQN.a(j, j2, 1, false);
        }
        g.pQN.a(197, j2, 1, false);
    }

    public static void fu(long j) {
        I(j, 2);
    }

    public static void a(int i, int i2, String str, int i3, int i4, boolean z, boolean z2, boolean z3, String str2) {
        a(i, i2, str, i3, vhb, z2 ? 0 : 1, i4 - 1, z3 ? 0 : 1, 1, z ? 0 : 1, str2);
    }

    public static void a(int i, int i2, int i3, boolean z, String str) {
        a(i, i2, "", i3, vhc, z ? 0 : 1, a.vhf - 1, 1, 1, 1, str);
    }

    public static void a(int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, String str) {
        a(i, i2, "", i3, vhd, z ? 0 : 1, a.vhf - 1, z3 ? 0 : 1, z2 ? 0 : 1, z4 ? 0 : 1, str);
    }

    private static void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str2) {
        g.pQN.h(11906, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9)});
        if (!bh.ov(str2) && !str2.equals("0")) {
            g.pQN.h(11907, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), str2});
        }
    }
}
