package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter.c;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$14 implements c {
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$14(SnsCommentDetailUI snsCommentDetailUI, m mVar) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
    }

    public final void LK(String str) {
        int i = 1;
        if (com.tencent.mm.plugin.sns.lucky.a.m.JU(this.rrO.byq())) {
            bjk bAQ = SnsCommentDetailUI.b(this.rAr).bAQ();
            if (SnsCommentDetailUI.b(this.rAr).rBe != 1) {
                i = 0;
            }
            SnsCommentDetailUI.a(this.rAr, str, bAQ, i);
            SnsCommentDetailUI.b(this.rAr).iJ(false);
            x.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
            SnsCommentDetailUI.s(this.rAr);
            new af().postDelayed(new 1(this), 100);
            return;
        }
        a.e(this.rAr.mController.xIM, this.rAr.rAn.xy(0));
    }
}
