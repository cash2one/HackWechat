package com.tencent.mm.plugin.subapp.a;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ak.c;
import com.tencent.mm.z.ar;

public final class b implements c {
    public final String gO(int i) {
        return P(i, true);
    }

    public final String gP(int i) {
        return P(i, false);
    }

    private String P(int i, boolean z) {
        int i2 = 0;
        ar.Hg();
        if (!com.tencent.mm.z.c.isSDCardAvailable()) {
            return null;
        }
        int i3;
        if (i != 0) {
            i3 = 0;
            while (i3 < 32) {
                i = (i >> 1) & Integer.MAX_VALUE;
                if (i == 0) {
                    break;
                }
                i3++;
            }
        } else {
            i3 = -1;
        }
        if (i3 != -1) {
            i2 = 1 << i3;
        }
        String q = i2 == 0 ? null : q(i2, z);
        if (e.bO(q)) {
            return q;
        }
        GR();
        return null;
    }

    public final void GR() {
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            ar.Hg();
            long a = bh.a((Long) com.tencent.mm.z.c.CU().get(66051, null), 0);
            long Wp = bh.Wp();
            if (432000000 <= Wp - a) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(66051, Long.valueOf(Wp));
                a aVar = new a();
            }
        }
    }

    public final boolean gQ(int i) {
        if (i == 0) {
            return false;
        }
        int i2 = 0;
        while (i2 < 32) {
            if (!e.bO(q((1 << i2) & i, false)) || !e.bO(q((1 << i2) & i, true))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public final String q(int i, boolean z) {
        if (i == 0) {
            return null;
        }
        return com.tencent.mm.compatible.util.e.gHv + "vuserpic_" + Integer.toHexString(i) + (z ? "_HD" : "") + ".png";
    }
}
