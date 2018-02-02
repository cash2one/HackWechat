package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.topstory.a.a.c;
import com.tencent.mm.plugin.webview.fts.topstory.a.d;

class f$12 implements OnClickListener {
    final /* synthetic */ f tpL;

    f$12(f fVar) {
        this.tpL = fVar;
    }

    public final void onClick(View view) {
        this.tpL.bPN();
        this.tpL.bPW();
        f.f(this.tpL).bQr();
        g bQd = g.bQd();
        c e = f.e(this.tpL);
        String g = f.g(this.tpL);
        d.bPs();
        bQd.tpX.setKeepScreenOn(true);
        bQd.tpX.bPM();
        bQd.tpX.Oh(g);
        bQd.tpY = e;
        bQd.tpZ = true;
        bQd.tqa = false;
        bQd.bQe();
        this.tpL.bPO();
        if (d.bPB().nbV) {
            g.pQN.h(791, 17);
        } else {
            g.pQN.h(791, 12);
        }
    }
}
