package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;

class SnsCommentDetailUI$28 implements e {
    final /* synthetic */ boolean qPf;
    final /* synthetic */ long rAC;
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$28(SnsCommentDetailUI snsCommentDetailUI, long j, boolean z) {
        this.rAr = snsCommentDetailUI;
        this.rAC = j;
        this.qPf = z;
    }

    public final void d(b bVar, int i) {
        if (i != -1) {
            SnsCommentDetailUI.A(this.rAr).m(this.rAC, this.qPf);
        }
    }
}
