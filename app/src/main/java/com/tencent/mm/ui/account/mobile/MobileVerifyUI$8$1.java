package com.tencent.mm.ui.account.mobile;

import com.tencent.mm.R;
import com.tencent.mm.ar.b;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.8;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p$c;

class MobileVerifyUI$8$1 implements p$c {
    final /* synthetic */ 8 xVn;

    MobileVerifyUI$8$1(8 8) {
        this.xVn = 8;
    }

    public final void a(n nVar) {
        nVar.f(0, this.xVn.xVi.getString(R.l.evt));
        if (b.lG(this.xVn.xVi.fAf)) {
            nVar.f(1, this.xVn.xVi.getString(R.l.dLI));
        }
        if (this.xVn.xVi.xUf == 2 && this.xVn.xVi.xVe) {
            nVar.f(2, this.xVn.xVi.getString(R.l.eDH));
        }
    }
}
