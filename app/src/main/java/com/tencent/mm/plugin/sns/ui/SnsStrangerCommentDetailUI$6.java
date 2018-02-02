package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.z.s;

class SnsStrangerCommentDetailUI$6 implements c {
    final /* synthetic */ SnsStrangerCommentDetailUI rGV;

    SnsStrangerCommentDetailUI$6(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.rGV = snsStrangerCommentDetailUI;
    }

    public final void jl(int i) {
        switch (i) {
            case 0:
                if (SnsStrangerCommentDetailUI.c(this.rGV).AF()) {
                    s.i(SnsStrangerCommentDetailUI.c(this.rGV));
                    SnsStrangerCommentDetailUI.c(this.rGV).Aj();
                    a.ift.um();
                    return;
                }
                s.h(SnsStrangerCommentDetailUI.c(this.rGV));
                SnsStrangerCommentDetailUI.c(this.rGV).Ai();
                a.ift.um();
                return;
            default:
                return;
        }
    }
}
