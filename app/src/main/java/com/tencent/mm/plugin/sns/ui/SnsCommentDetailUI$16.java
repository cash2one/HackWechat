package com.tencent.mm.plugin.sns.ui;

class SnsCommentDetailUI$16 implements Runnable {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$16(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void run() {
        this.rAr.aWs();
        SnsCommentDetailUI.l(this.rAr).kVD = SnsCommentDetailUI.w(this.rAr);
        SnsCommentDetailUI.l(this.rAr).run();
    }
}
