package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.kernel.g;

class u$1 implements e {
    final /* synthetic */ ol lji;
    final /* synthetic */ u ljj;

    u$1(u uVar, ol olVar) {
        this.ljj = uVar;
        this.lji = olVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.ljj.iib != null && this.ljj.iib.isShowing()) {
            this.ljj.iib.dismiss();
            this.ljj.iib = null;
        }
        g.CG().b(1800, this);
        k kVar2 = (k) kVar;
        kVar2.a(new 3(this)).b(new 2(this, kVar2)).c(new 1(this));
        this.lji.fGq.fqI.run();
    }
}
