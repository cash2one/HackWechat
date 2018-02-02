package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.te;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.remittance.model.z;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.bs;
import com.tencent.mm.z.p;
import java.util.HashMap;
import java.util.HashSet;

public class b implements ap {
    private static HashMap<Integer, d> gwY;
    private a hiB = new 3(this);
    private bs.a lNW = new 4(this);
    private z pGW = null;
    public com.tencent.mm.plugin.remittance.b.b pGX = null;
    private com.tencent.mm.plugin.remittance.b.d pGY = null;
    private c<mm> pGZ = new 5(this);
    private c<te> pHa = new 6(this);

    static {
        com.tencent.mm.wallet_core.a.i("RemittanceProcess", a.class);
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("DelayTransferRecord".hashCode()), new 1());
        gwY.put(Integer.valueOf("RemittanceRecord".hashCode()), new 2());
    }

    public static b bnm() {
        return (b) p.s(b.class);
    }

    public static com.tencent.mm.plugin.remittance.b.b bnn() {
        if (bnm().pGX == null) {
            b bnm = bnm();
            g.Dk();
            bnm.pGX = new com.tencent.mm.plugin.remittance.b.b(g.Dj().gQj);
        }
        return bnm().pGX;
    }

    public static com.tencent.mm.plugin.remittance.b.d bno() {
        if (bnm().pGY == null) {
            b bnm = bnm();
            g.Dk();
            bnm.pGY = new com.tencent.mm.plugin.remittance.b.d(g.Dj().gQj);
        }
        return bnm().pGY;
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        if (this.pGW != null) {
            z zVar = this.pGW;
            synchronized (zVar.lock) {
                zVar.pLG = new HashSet();
                zVar.pLH.clear();
            }
        }
        com.tencent.mm.z.c.c.IF().c(this.hiB);
        ((n) g.k(n.class)).getSysCmdMsgExtension().a("paymsg", this.lNW, true);
        com.tencent.mm.sdk.b.a.xef.a(this.pGZ);
        com.tencent.mm.sdk.b.a.xef.a(this.pHa);
    }

    public final void onAccountRelease() {
        com.tencent.mm.z.c.c.IF().j(this.hiB);
        ((n) g.k(n.class)).getSysCmdMsgExtension().b("paymsg", this.lNW, true);
        com.tencent.mm.sdk.b.a.xef.c(this.pGZ);
        com.tencent.mm.sdk.b.a.xef.c(this.pHa);
    }

    public final z bnp() {
        if (this.pGW == null) {
            this.pGW = new z();
        }
        return this.pGW;
    }
}
