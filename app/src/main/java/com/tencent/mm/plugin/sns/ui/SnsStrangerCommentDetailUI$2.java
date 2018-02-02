package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class SnsStrangerCommentDetailUI$2 implements Runnable {
    int rBa = -1;
    int rBb = 10;
    final /* synthetic */ SnsStrangerCommentDetailUI rGV;

    SnsStrangerCommentDetailUI$2(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.rGV = snsStrangerCommentDetailUI;
    }

    public final void run() {
        if (!SnsStrangerCommentDetailUI.h(this.rGV)) {
            this.rBb = 10;
        }
        SnsStrangerCommentDetailUI.i(this.rGV);
        x.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.a(this.rGV).getBottom() + " footer.top" + SnsStrangerCommentDetailUI.a(this.rGV).getTop());
        int top = SnsStrangerCommentDetailUI.j(this.rGV).getTop();
        int i = this.rBb;
        this.rBb = i - 1;
        if (i > 0 && (this.rBa != top || SnsStrangerCommentDetailUI.a(this.rGV).getBottom() == SnsStrangerCommentDetailUI.g(this.rGV))) {
            new af().postDelayed(this, 30);
        }
        this.rBa = top;
        c.b(SnsStrangerCommentDetailUI.a(this.rGV), SnsStrangerCommentDetailUI.a(this.rGV).getCount() - 1);
    }
}
