package com.tencent.mm.plugin.soter.d;

import com.tencent.mm.plugin.soter.c.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.j.c;

class b$2 implements a<c<Integer, String>> {
    final /* synthetic */ e rSr;

    b$2(e eVar) {
        this.rSr = eVar;
    }

    public final /* synthetic */ void aW(Object obj) {
        c cVar = (c) obj;
        String str = (String) cVar.get(1);
        x.e("MicroMsg.SoterInitManager", "alvinluo onInterrupt errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(((Integer) cVar.get(0)).intValue()), str});
        if (this.rSr != null) {
            this.rSr.yc(r1);
        }
    }
}
