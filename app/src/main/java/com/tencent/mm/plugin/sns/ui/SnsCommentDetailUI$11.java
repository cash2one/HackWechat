package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.a;

class SnsCommentDetailUI$11 implements a {
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$11(SnsCommentDetailUI snsCommentDetailUI, m mVar) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
    }

    public final void bAH() {
        if (com.tencent.mm.plugin.sns.lucky.a.m.JU(this.rrO.byq())) {
            if (this.rAr.mController.xJg != 1 && !SnsCommentDetailUI.b(this.rAr).bAN()) {
                SnsCommentDetailUI.u(this.rAr);
            }
        } else if (SnsCommentDetailUI.t(this.rAr) == null || !SnsCommentDetailUI.t(this.rAr).isShowing()) {
            SnsCommentDetailUI.a(this.rAr, com.tencent.mm.plugin.sns.lucky.ui.a.e(this.rAr.mController.xIM, this.rAr.rAn.xy(0)));
        }
    }
}
