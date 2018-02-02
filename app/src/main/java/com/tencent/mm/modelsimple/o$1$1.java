package com.tencent.mm.modelsimple;

import com.tencent.mm.g.a.a;
import com.tencent.mm.modelsimple.o.1;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class o$1$1 extends c<a> {
    final /* synthetic */ String hNc;
    final /* synthetic */ String hNd;
    final /* synthetic */ 1 hNe;

    o$1$1(1 1, String str, String str2) {
        this.hNe = 1;
        this.hNc = str;
        this.hNd = str2;
        this.xen = a.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.sdk.b.a.xef.c(o.b(this.hNe.hNb));
        o.a(this.hNe.hNb, null);
        x.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after 5s[%b]", Boolean.valueOf(ac.cfp()));
        ag.h(new 1(this), 5000);
        return true;
    }
}
