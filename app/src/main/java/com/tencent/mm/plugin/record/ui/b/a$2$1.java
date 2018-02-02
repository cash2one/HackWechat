package com.tencent.mm.plugin.record.ui.b;

import com.tencent.mm.R;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.mr;
import com.tencent.mm.plugin.record.ui.b.a.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class a$2$1 implements c {
    final /* synthetic */ 2 pGI;

    a$2$1(2 2) {
        this.pGI = 2;
    }

    public final void a(n nVar) {
        if (2.a(this.pGI).wdR == 0) {
            if (2.b(this.pGI).aHJ()) {
                nVar.f(2, 2.c(this.pGI).getString(R.l.egz));
            }
            if (2.b(this.pGI).aHK()) {
                nVar.f(1, 2.c(this.pGI).getString(R.l.egb));
            }
            nVar.f(3, 2.c(this.pGI).getString(R.l.egu));
            mr mrVar = (mr) this.pGI.pGF.msp.get(2.d(this.pGI));
            if (mrVar == null) {
                b mpVar = new mp();
                mpVar.fEA.filePath = 2.d(this.pGI);
                a.xef.m(mpVar);
            } else if (!bh.ov(mrVar.fED.result)) {
                nVar.f(4, 2.c(this.pGI).getString(com.tencent.mm.plugin.scanner.a.az(mrVar.fED.fqb, mrVar.fED.result) ? R.l.eCr : R.l.eCq));
            }
        }
    }
}
