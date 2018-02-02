package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

class c$4 implements OnClickListener {
    final /* synthetic */ c zIW;

    c$4(c cVar) {
        this.zIW = cVar;
    }

    public final void onClick(View view) {
        if (this.zIW.inJ != null && this.zIW.inJ.isShowing()) {
            this.zIW.inJ.dismiss();
        }
    }
}
