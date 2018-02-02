package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.n;

class b$1 implements OnClickListener {
    final /* synthetic */ n pCK;
    final /* synthetic */ b pCL;

    b$1(b bVar, n nVar) {
        this.pCL = bVar;
        this.pCK = nVar;
    }

    public final void onClick(View view) {
        if (b.a(this.pCL) != null) {
            b.a(this.pCL).a(this.pCK);
        }
    }
}
