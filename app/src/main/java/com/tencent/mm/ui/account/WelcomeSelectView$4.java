package com.tencent.mm.ui.account;

import com.tencent.mm.network.e;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bd;
import com.tencent.mm.z.bd.a;

class WelcomeSelectView$4 implements Runnable {
    final /* synthetic */ WelcomeSelectView xST;

    WelcomeSelectView$4(WelcomeSelectView welcomeSelectView) {
        this.xST = welcomeSelectView;
    }

    public final void run() {
        ar.CG().a(new bd(new a(this) {
            final /* synthetic */ WelcomeSelectView$4 xSU;

            {
                this.xSU = r1;
            }

            public final void a(e eVar) {
            }
        }, "launch normal"), 0);
    }
}
