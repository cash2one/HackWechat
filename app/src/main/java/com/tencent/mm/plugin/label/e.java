package com.tencent.mm.plugin.label;

import com.tencent.mm.as.a;
import com.tencent.mm.as.b;
import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.util.HashMap;

public class e implements ap {
    private static HashMap<Integer, d> gwY;
    private ac nOA;
    private d nOB = new d();

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new 1());
        gwY.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return ab.gJN;
            }
        });
    }

    private static e aUV() {
        ar.Ha();
        e eVar = (e) bp.hY("plugin.label");
        if (eVar == null) {
            synchronized (e.class) {
                if (eVar == null) {
                    eVar = new e();
                    ar.Ha().a("plugin.label", eVar);
                }
            }
        }
        return eVar;
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        a bVar = new b();
        com.tencent.mm.plugin.label.a.a.nOC = bVar;
        b.hEy = bVar;
        com.tencent.mm.sdk.b.a.xef.b(this.nOB);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.plugin.label.a.a.nOC = null;
        com.tencent.mm.sdk.b.a.xef.c(this.nOB);
    }

    public static ac aUW() {
        g.Dh().Ct();
        if (aUV().nOA == null) {
            e aUV = aUV();
            ar.Hg();
            aUV.nOA = new ac(c.EV());
        }
        return aUV().nOA;
    }
}
