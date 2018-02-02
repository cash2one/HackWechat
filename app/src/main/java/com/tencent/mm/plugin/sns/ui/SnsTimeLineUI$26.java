package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.TestTimeForSns.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$26 implements a {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$26(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void aOk() {
        x.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
        SnsTimeLineUI.w(this.rIN).post(new Runnable(this) {
            final /* synthetic */ SnsTimeLineUI$26 rIW;

            {
                this.rIW = r1;
            }

            public final void run() {
                if (SnsTimeLineUI.a(this.rIW.rIN) == null || SnsTimeLineUI.w(this.rIW.rIN) == null) {
                    x.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
                    return;
                }
                SnsTimeLineUI.w(this.rIW.rIN).setListener(null);
                SnsTimeLineUI.a(this.rIW.rIN, SnsTimeLineUI.A(this.rIW.rIN));
                if (SnsTimeLineUI.B(this.rIW.rIN)) {
                    x.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
                    return;
                }
                if (SnsTimeLineUI.t(this.rIW.rIN)) {
                    ae.bvl().x(ae.bvC().qXh, -1);
                }
                if (!SnsTimeLineUI.t(this.rIW.rIN)) {
                    SnsTimeLineUI.k(this.rIW.rIN).rRU.b(SnsTimeLineUI.p(this.rIW.rIN), SnsTimeLineUI.i(this.rIW.rIN), SnsTimeLineUI.j(this.rIW.rIN), SnsTimeLineUI.q(this.rIW.rIN));
                }
                SnsTimeLineUI.a(this.rIW.rIN, false);
                if (this.rIW.rIN.rzU != null) {
                    this.rIW.rIN.rzU.btY();
                }
            }
        });
    }
}
