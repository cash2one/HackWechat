package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class e$17 implements OnClickListener {
    final /* synthetic */ e srL;

    e$17(e eVar) {
        this.srL = eVar;
    }

    public final void onClick(View view) {
        g.pQN.h(11618, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
        if (!(this.srL.spN == null || this.srL.spN.get() == null)) {
            ((c) this.srL.spN.get()).jh(true);
        }
        if (this.srL.sqg != null) {
            this.srL.sqg.D(false, true);
        }
    }
}
