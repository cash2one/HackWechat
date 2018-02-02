package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class NormalUserFooterPreference$a$1$2 implements c {
    final /* synthetic */ 1 pkD;

    NormalUserFooterPreference$a$1$2(1 1) {
        this.pkD = 1;
    }

    public final void a(n nVar) {
        CharSequence string;
        nVar.ai(1, R.l.dVE, R.k.dwN);
        if (NormalUserFooterPreference.a(this.pkD.pkC.pkA).AH()) {
            string = NormalUserFooterPreference.b(this.pkD.pkC.pkA).getResources().getString(R.l.dXd);
        } else {
            string = NormalUserFooterPreference.b(this.pkD.pkC.pkA).getResources().getString(R.l.dUX);
        }
        nVar.a(2, string, R.k.dwP);
        nVar.ai(3, R.l.dVO, R.k.dwF);
        nVar.ai(4, R.l.dWp, R.k.dwQ);
        nVar.ai(9, R.l.dMl, R.k.dwr);
        if (NormalUserFooterPreference.a(this.pkD.pkC.pkA).AF()) {
            string = NormalUserFooterPreference.b(this.pkD.pkC.pkA).getString(R.l.dVK);
        } else {
            string = NormalUserFooterPreference.b(this.pkD.pkC.pkA).getString(R.l.dVH);
        }
        nVar.a(5, string, R.k.dwo);
        if (!NormalUserFooterPreference.c(this.pkD.pkC.pkA)) {
            nVar.ai(6, R.l.dKO, R.k.dwt);
        }
        nVar.ai(7, R.l.dUr, R.k.dwu);
    }
}
