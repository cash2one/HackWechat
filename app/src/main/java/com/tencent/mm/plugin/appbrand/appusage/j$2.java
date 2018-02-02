package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.protocal.c.bpu;

class j$2 implements a {
    final /* synthetic */ String gIT;
    final /* synthetic */ int iJO;
    final /* synthetic */ j iJQ;
    final /* synthetic */ j.a iJR;

    j$2(j jVar, j.a aVar, String str, int i) {
        this.iJQ = jVar;
        this.iJR = aVar;
        this.gIT = str;
        this.iJO = i;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        if (!(i == 0 && i2 == 0 && ((bpu) bVar.hmh.hmo).vVA.lOr == 0) && j.a(this.iJQ).isOpen()) {
            j.b(this.iJQ).a(this.iJR, false);
            if (this.iJQ.an(this.gIT, this.iJO)) {
                this.iJQ.b("single", 2, this.iJR);
            }
        }
        return 0;
    }
}
