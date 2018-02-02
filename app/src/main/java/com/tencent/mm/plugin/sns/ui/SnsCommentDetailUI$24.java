package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.sdk.platformtools.bh;

class SnsCommentDetailUI$24 implements f {
    final /* synthetic */ ak rAA;
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$24(SnsCommentDetailUI snsCommentDetailUI, m mVar, ak akVar) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
        this.rAA = akVar;
    }

    public final void b(b bVar, long j) {
        if (SnsCommentDetailUI.A(this.rAr) != null) {
            int bsO = (int) bVar.bsO();
            SnsCommentDetailUI.A(this.rAr).b(this.rrO.field_snsId, bh.Wq(), false);
            SnsCommentDetailUI.A(this.rAr).v(this.rrO.field_snsId, bsO);
            if (j >= 3) {
                SnsCommentDetailUI.A(this.rAr).z(this.rrO.field_snsId, this.rrO.field_snsId);
                this.rAA.qvN.a(null);
            }
        }
    }
}
