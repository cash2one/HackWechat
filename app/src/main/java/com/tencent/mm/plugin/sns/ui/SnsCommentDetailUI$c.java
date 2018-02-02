package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$c implements Runnable {
    int Dy = -1;
    int kVD;
    private int offset = 0;
    final /* synthetic */ SnsCommentDetailUI rAr;
    private int rBa = -1;
    private int rBb = 10;

    SnsCommentDetailUI$c(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void run() {
        this.rBb = 10;
        SnsCommentDetailUI.a(this.rAr);
        this.rBa = SnsCommentDetailUI.b(this.rAr).getTop();
        int i = this.rBa - this.kVD;
        x.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[]{Integer.valueOf(SnsCommentDetailUI.c(this.rAr).getBottom()), Integer.valueOf(SnsCommentDetailUI.d(this.rAr)), Integer.valueOf(this.rBa), Integer.valueOf(SnsCommentDetailUI.b(this.rAr).getTop()), Integer.valueOf(i)});
        if (i == this.offset) {
            SnsCommentDetailUI.c(this.rAr).setSelectionFromTop(SnsCommentDetailUI.c(this.rAr).getHeaderViewsCount() + this.Dy, i);
            this.rBb = 0;
            this.offset = 0;
            return;
        }
        int i2 = this.rBb;
        this.rBb = i2 - 1;
        if (i2 > 0) {
            new af().postDelayed(this, 100);
            this.offset = i;
            return;
        }
        this.offset = 0;
        this.rBb = 0;
    }
}
