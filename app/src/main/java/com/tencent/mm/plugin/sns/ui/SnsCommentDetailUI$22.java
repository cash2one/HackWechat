package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.storage.m;

class SnsCommentDetailUI$22 implements e {
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$22(SnsCommentDetailUI snsCommentDetailUI, m mVar) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
    }

    public final void d(b bVar, int i) {
        if (i != -1 && SnsCommentDetailUI.A(this.rAr) != null) {
            SnsCommentDetailUI.A(this.rAr).m(this.rrO.field_snsId, false);
        }
    }
}
