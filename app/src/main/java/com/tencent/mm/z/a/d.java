package com.tencent.mm.z.a;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.ae.d.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;

public final class d implements com.tencent.mm.ae.d {
    public final b b(a aVar) {
        bw bwVar = aVar.hmq;
        if (bwVar == null || bwVar.vGZ == null) {
            x.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
        } else {
            String a = n.a(bwVar.vGZ);
            g.Dj().CU().set(328193, a);
            c Ij = g.Ij();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                Ij.if(a);
                a = (String) g.Dj().CU().get(328197, null);
                if (bh.ov(a) || !(Ij.hig == null || a.equals(Ij.hig.hic))) {
                    g.Dj().CU().set(328197, Ij.hig.hic);
                    g.Dj().CU().set(328195, Boolean.valueOf(false));
                    g.Dj().CU().set(328194, Boolean.valueOf(false));
                    g.Dj().CU().set(328196, Boolean.valueOf(false));
                    x.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
                }
            } catch (Exception e) {
                x.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", new Object[]{e.toString()});
            }
            x.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            if (g.Ij().Ih()) {
                f.ih(g.Ij().hig.hic);
            }
        }
        return null;
    }

    public final void h(au auVar) {
    }
}
