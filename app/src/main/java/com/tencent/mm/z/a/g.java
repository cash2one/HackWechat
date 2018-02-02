package com.tencent.mm.z.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;

public class g implements ap {
    private c him = null;

    private static g Ii() {
        return (g) p.s(g.class);
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        c Ij = Ij();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Ij.if((String) com.tencent.mm.kernel.g.Dj().CU().get(328193, null));
            if (Ij.Ih()) {
                f.ih(Ij.hig.hic);
            }
        } catch (Exception e) {
            x.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[]{e.toString()});
        }
        x.i("MicroMsg.abtest.AbTestManager", "[Abtest] init use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        c Ij = Ij();
        Ij.hih = null;
        Ij.hig = null;
    }

    public static c Ij() {
        com.tencent.mm.kernel.g.Dh().Ct();
        if (Ii().him == null) {
            Ii().him = new c();
        }
        return Ii().him;
    }
}
