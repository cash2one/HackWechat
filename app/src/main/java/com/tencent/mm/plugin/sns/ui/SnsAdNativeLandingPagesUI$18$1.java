package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI.18;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class SnsAdNativeLandingPagesUI$18$1 implements c {
    final /* synthetic */ 18 ryE;

    SnsAdNativeLandingPagesUI$18$1(18 18) {
        this.ryE = 18;
    }

    public final void a(n nVar) {
        if (SnsAdNativeLandingPagesUI.q(this.ryE.ryv) == 0 || (SnsAdNativeLandingPagesUI.q(this.ryE.ryv) & 2) == 0) {
            nVar.a(1, this.ryE.ryv.getString(j.eEG), i.dwQ);
        }
        if (SnsAdNativeLandingPagesUI.q(this.ryE.ryv) == 0 || (SnsAdNativeLandingPagesUI.q(this.ryE.ryv) & 1) == 0) {
            nVar.a(2, this.ryE.ryv.getString(j.qKd), i.dwF);
        }
        if ((SnsAdNativeLandingPagesUI.q(this.ryE.ryv) == 0 || (SnsAdNativeLandingPagesUI.q(this.ryE.ryv) & 4) == 0) && SnsAdNativeLandingPagesUI.r(this.ryE.ryv) != 7) {
            nVar.a(3, this.ryE.ryv.getString(j.dQP), i.dwy);
        }
        if ((SnsAdNativeLandingPagesUI.q(this.ryE.ryv) == 0 || SnsAdNativeLandingPagesUI.s(this.ryE.ryv)) && SnsAdNativeLandingPagesUI.t(this.ryE.ryv) == 2 && SnsAdNativeLandingPagesUI.u(this.ryE.ryv)) {
            nVar.a(4, SnsAdNativeLandingPagesUI.v(this.ryE.ryv) != null ? SnsAdNativeLandingPagesUI.v(this.ryE.ryv) : "", 0);
        }
    }
}
