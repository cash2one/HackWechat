package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.7;
import com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI.8;
import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$7$1 implements Runnable {
    final /* synthetic */ 7 rGW;

    SnsStrangerCommentDetailUI$7$1(7 7) {
        this.rGW = 7;
    }

    public final void run() {
        x.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
        SnsStrangerCommentDetailUI.d(this.rGW.rGV).a(null, null);
        if (SnsStrangerCommentDetailUI.e(this.rGW.rGV)) {
            SnsStrangerCommentDetailUI.a(this.rGW.rGV, false);
            ae.aNT().postDelayed(new 8(this.rGW.rGV), 10);
        }
    }
}
