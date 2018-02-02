package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$9 implements Runnable {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$9(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void run() {
        SnsCommentDetailUI.a(this.rAr, SnsCommentDetailUI.c(this.rAr).getBottom());
        x.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + SnsCommentDetailUI.d(this.rAr));
    }
}
