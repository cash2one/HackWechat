package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class i$1 implements OnClickListener {
    final /* synthetic */ i sTF;

    i$1(i iVar) {
        this.sTF = iVar;
    }

    public final void onClick(View view) {
        i.a(this.sTF);
        this.sTF.dismiss();
    }
}
