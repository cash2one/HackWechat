package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class f$1 implements OnClickListener {
    final /* synthetic */ f ssq;

    f$1(f fVar) {
        this.ssq = fVar;
    }

    public final void onClick(View view) {
        g.pQN.h(11618, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
        if (!(this.ssq.spN == null || this.ssq.spN.get() == null)) {
            ((c) this.ssq.spN.get()).jh(true);
        }
        if (this.ssq.sqg != null) {
            this.ssq.sqg.D(false, true);
        }
    }
}
