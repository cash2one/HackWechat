package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$10 implements Runnable {
    final /* synthetic */ SnsStrangerCommentDetailUI rGV;

    SnsStrangerCommentDetailUI$10(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.rGV = snsStrangerCommentDetailUI;
    }

    public final void run() {
        SnsStrangerCommentDetailUI.a(this.rGV, SnsStrangerCommentDetailUI.a(this.rGV).getBottom());
        x.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + SnsStrangerCommentDetailUI.g(this.rGV));
    }
}
