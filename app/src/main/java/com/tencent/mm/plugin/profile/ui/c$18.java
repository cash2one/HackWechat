package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class c$18 implements c {
    final /* synthetic */ c piX;

    c$18(c cVar) {
        this.piX = cVar;
    }

    public final void a(n nVar) {
        if (this.piX.kEC != null && this.piX.kEC.Le()) {
            nVar.eQ(1, R.l.dWo);
            nVar.eQ(3, R.l.dMl);
            nVar.eQ(4, R.l.dUB);
            nVar.eQ(5, R.l.dUr);
        } else if (this.piX.kEC == null || !this.piX.kEC.Lf()) {
            nVar.eQ(1, R.l.dWo);
            nVar.eQ(2, R.l.dUw);
            if (!this.piX.Hz(this.piX.jLe.field_username)) {
                nVar.eQ(3, R.l.dMl);
                nVar.eQ(4, R.l.dUB);
            }
            nVar.eQ(5, R.l.dUr);
        } else {
            nVar.eQ(5, R.l.dUr);
        }
    }
}
