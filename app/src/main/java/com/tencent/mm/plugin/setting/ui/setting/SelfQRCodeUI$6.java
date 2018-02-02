package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;
import com.tencent.mm.z.s;

class SelfQRCodeUI$6 implements p$c {
    final /* synthetic */ SelfQRCodeUI qhD;

    SelfQRCodeUI$6(SelfQRCodeUI selfQRCodeUI) {
        this.qhD = selfQRCodeUI;
    }

    public final void a(n nVar) {
        boolean eV = s.eV(SelfQRCodeUI.c(this.qhD));
        boolean jX = f.jX(SelfQRCodeUI.c(this.qhD));
        if (!(jX || eV)) {
            nVar.eQ(2, R.l.eJw);
        }
        nVar.eQ(1, R.l.eJA);
        if (!jX) {
            nVar.eQ(3, R.l.eJL);
        }
        if (SelfQRCodeUI.d(this.qhD)) {
            nVar.eQ(4, R.l.eJK);
        }
    }
}
