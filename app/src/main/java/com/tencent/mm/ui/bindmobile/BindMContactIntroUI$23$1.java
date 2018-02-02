package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI.23;

class BindMContactIntroUI$23$1 implements c {
    final /* synthetic */ 23 ylM;

    BindMContactIntroUI$23$1(23 23) {
        this.ylM = 23;
    }

    public final void a(n nVar) {
        nVar.setHeaderTitle(R.l.dLf);
        if ((this.ylM.ylL & 2) != 0) {
            nVar.eQ(0, R.l.dLs);
        }
        if ((this.ylM.ylL & 1) != 0) {
            nVar.eQ(1, R.l.dKN);
        }
    }
}
