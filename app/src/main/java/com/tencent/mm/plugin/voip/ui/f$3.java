package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class f$3 implements OnClickListener {
    final /* synthetic */ f ssq;

    f$3(f fVar) {
        this.ssq = fVar;
    }

    public final void onClick(View view) {
        g.pQN.h(11619, new Object[]{Integer.valueOf(3)});
        if (this.ssq.spN != null && this.ssq.spN.get() != null) {
            ((c) this.ssq.spN.get()).bHe();
        }
    }
}
