package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class SnsCommentDetailUI$15 implements SnsCommentFooter$b {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$15(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void bAI() {
        SnsCommentDetailUI.v(this.rAr);
        if (SnsCommentDetailUI.c(this.rAr).getFirstVisiblePosition() > 1 || SnsCommentDetailUI.c(this.rAr).getLastVisiblePosition() <= 0) {
            c.b(SnsCommentDetailUI.c(this.rAr), 1);
        }
    }
}
