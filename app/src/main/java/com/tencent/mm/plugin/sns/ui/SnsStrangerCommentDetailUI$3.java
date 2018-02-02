package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$3 implements c {
    final /* synthetic */ SnsStrangerCommentDetailUI rGV;

    SnsStrangerCommentDetailUI$3(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.rGV = snsStrangerCommentDetailUI;
    }

    public final void LK(String str) {
        x.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
        SnsStrangerCommentDetailUI.a(this.rGV, true);
        SnsStrangerCommentDetailUI.a(this.rGV, SnsStrangerCommentDetailUI.k(this.rGV), str);
    }
}
