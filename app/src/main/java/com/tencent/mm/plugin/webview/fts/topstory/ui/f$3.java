package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class f$3 implements OnClickListener {
    final /* synthetic */ f tpL;

    f$3(f fVar) {
        this.tpL = fVar;
    }

    public final void onClick(View view) {
        g.pQN.h(791, 21);
        f.c(this.tpL, !f.q(this.tpL));
        g.bQd().setMute(f.q(this.tpL));
        if (f.q(this.tpL)) {
            f.f(this.tpL).At();
        } else {
            f.f(this.tpL).bQp();
        }
        f.f(this.tpL).bQr();
    }
}
