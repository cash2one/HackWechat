package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.11;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.z.s;

class NormalUserFooterPreference$a$11$2 implements c {
    final /* synthetic */ 11 pkJ;

    NormalUserFooterPreference$a$11$2(11 11) {
        this.pkJ = 11;
    }

    public final void a(n nVar) {
        if (!this.pkJ.pkH) {
            nVar.ai(1, R.l.dVE, R.k.dwN);
        }
        if (!this.pkJ.pkI) {
            if (NormalUserFooterPreference.a(this.pkJ.pkC.pkA).AF()) {
                nVar.ai(8, R.l.dVK, R.k.dwo);
            } else if (!s.gD(NormalUserFooterPreference.a(this.pkJ.pkC.pkA).field_username)) {
                nVar.ai(5, R.l.dVH, R.k.dwo);
            }
        }
    }
}
