package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsoluteLayout.LayoutParams;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI.a;

class SnsTimeLineUI$43 implements Runnable {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$43(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void run() {
        SnsTimeLineUI.h(this.rIN).nKG.setSelection(0);
        a z = SnsTimeLineUI.z(this.rIN);
        if (z.rJg) {
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.l(z.rIN).getLayoutParams();
            layoutParams.y = z.rJh;
            SnsTimeLineUI.l(z.rIN).setLayoutParams(layoutParams);
            z.rJa = z.rJi;
            z.rJc = z.rJj;
        }
        SnsTimeLineUI.z(this.rIN).bBS();
        SnsTimeLineUI.k(this.rIN).rRU.b(SnsTimeLineUI.p(this.rIN), SnsTimeLineUI.i(this.rIN), SnsTimeLineUI.j(this.rIN), SnsTimeLineUI.q(this.rIN));
    }
}
