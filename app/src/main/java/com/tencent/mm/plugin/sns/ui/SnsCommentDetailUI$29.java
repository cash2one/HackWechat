package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.bh;

class SnsCommentDetailUI$29 implements f {
    final /* synthetic */ int hHw;
    final /* synthetic */ boolean qPf;
    final /* synthetic */ ak rAA;
    final /* synthetic */ long rAC;
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$29(SnsCommentDetailUI snsCommentDetailUI, long j, boolean z, int i, ak akVar) {
        this.rAr = snsCommentDetailUI;
        this.rAC = j;
        this.qPf = z;
        this.hHw = i;
        this.rAA = akVar;
    }

    public final void b(b bVar, long j) {
        int bsO = (int) bVar.bsO();
        SnsCommentDetailUI.A(this.rAr).b(this.rAC, bh.Wq(), this.qPf);
        SnsCommentDetailUI.A(this.rAr).a(this.rAC, bsO, true, this.qPf);
        SnsCommentDetailUI.A(this.rAr).z(this.rAC, this.rAC + ((long) this.hHw));
        this.rAA.qvN.a(null);
    }
}
