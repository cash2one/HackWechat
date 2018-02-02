package com.tencent.mm.ui.account;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class e$1 implements c {
    final /* synthetic */ Context val$context;
    final /* synthetic */ int xOg;

    e$1(int i, Context context) {
        this.xOg = i;
        this.val$context = context;
    }

    public final void a(n nVar) {
        if ((this.xOg & 1) != 0) {
            nVar.f(1, this.val$context.getString(R.l.eCS));
        }
        if ((this.xOg & 2) != 0) {
            nVar.f(2, this.val$context.getString(R.l.eCT));
        }
        if ((this.xOg & 4) != 0) {
            nVar.f(4, this.val$context.getString(R.l.eCR));
        }
        if ((this.xOg & 8) > 0) {
            nVar.f(8, this.val$context.getString(R.l.eXB));
        }
    }
}
