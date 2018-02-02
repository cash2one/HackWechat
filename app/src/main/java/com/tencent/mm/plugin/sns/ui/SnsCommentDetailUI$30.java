package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.storage.x;

class SnsCommentDetailUI$30 implements OnClickListener {
    final /* synthetic */ x rAD;
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$30(SnsCommentDetailUI snsCommentDetailUI, m mVar, x xVar) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
        this.rAD = xVar;
    }

    public final void onClick(View view) {
        k cVar = new c(this.rrO.byz(), 24, 2, "", this.rrO.byD(), this.rrO.bxW());
        g.Dk();
        g.Di().gPJ.a(cVar, 0);
        SnsCommentDetailUI.b(this.rAr).b(this.rAD.AQ(), null);
        SnsCommentDetailUI.b(this.rAr).iJ(true);
        SnsCommentDetailUI.B(this.rAr).setVisibility(8);
        SnsCommentDetailUI.u(this.rAr);
    }
}
