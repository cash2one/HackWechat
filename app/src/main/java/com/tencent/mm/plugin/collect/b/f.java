package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class f implements e {
    private final String TAG = "MicroMsg.F2fGetPayUrlManager";
    public Map<l, a> gKa = new HashMap();

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            l lVar = (l) kVar;
            a aVar = (a) this.gKa.get(kVar);
            if (aVar == null) {
                x.w("MicroMsg.F2fGetPayUrlManager", "no match callback");
                return;
            }
            if (i == 0 && i2 == 0) {
                aVar.a(true, lVar.liG);
            } else {
                x.e("MicroMsg.F2fGetPayUrlManager", "net error: %s", new Object[]{lVar});
                aVar.a(false, null);
            }
            this.gKa.remove(kVar);
        }
    }
}
