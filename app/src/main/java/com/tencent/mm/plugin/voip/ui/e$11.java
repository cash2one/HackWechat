package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;

class e$11 implements OnClickListener {
    final /* synthetic */ e srL;

    e$11(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        if (this.srL.spN != null && this.srL.spN.get() != null) {
            ((c) this.srL.spN.get()).bGS();
        }
    }
}
