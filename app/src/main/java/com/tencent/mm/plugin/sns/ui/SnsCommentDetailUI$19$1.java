package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.19;

class SnsCommentDetailUI$19$1 implements Runnable {
    final /* synthetic */ boolean hyH;
    final /* synthetic */ 19 rAt;

    SnsCommentDetailUI$19$1(19 19, boolean z) {
        this.rAt = 19;
        this.hyH = z;
    }

    public final void run() {
        if (this.hyH && !this.rAt.rAr.isFinishing() && this.rAt.rAr.rAo < 5) {
            this.rAt.rAr.bAD();
        }
        SnsCommentDetailUI snsCommentDetailUI = this.rAt.rAr;
        snsCommentDetailUI.rAo++;
    }
}
