package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.a.g;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.k;

public final class e extends c<bc> {
    public e() {
        this.xen = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.fpl.fpm == 38) {
            int i = bcVar.fpl.fpn;
            int i2 = bcVar.fpl.fpo;
            String str = bcVar.fpl.filePath;
            if (!bh.ov(str) || com.tencent.mm.a.e.bO(str)) {
                boolean z;
                String abQ = AppBrandGlobalSystemConfig.abQ();
                if (com.tencent.mm.a.e.bO(abQ)) {
                    String bV = g.bV(str);
                    z = (bh.ov(bV) || bV.equals(g.bV(abQ))) ? false : true;
                } else {
                    z = true;
                }
                if (z) {
                    AppBrandGlobalSystemConfig.abP();
                    k.fp(str, abQ);
                    com.tencent.mm.pluginsdk.i.a.b.b.c.bZm().e(38, i, i2, true);
                }
            }
        }
        return true;
    }
}
