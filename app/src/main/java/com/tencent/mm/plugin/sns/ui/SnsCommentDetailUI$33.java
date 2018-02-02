package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.lucky.ui.a;
import com.tencent.mm.plugin.sns.storage.m;

class SnsCommentDetailUI$33 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$33(SnsCommentDetailUI snsCommentDetailUI, m mVar) {
        this.rAr = snsCommentDetailUI;
        this.rrO = mVar;
    }

    public final void onClick(View view) {
        if (com.tencent.mm.plugin.sns.lucky.a.m.JU(this.rrO.byq())) {
            SnsCommentDetailUI.b(this.rAr).qTX = null;
            SnsCommentDetailUI.b(this.rAr).LW("");
            SnsCommentDetailUI.b(this.rAr).rBe = 0;
            SnsCommentDetailUI.b(this.rAr).iJ(true);
            SnsCommentDetailUI.B(this.rAr).setVisibility(8);
            SnsCommentDetailUI.u(this.rAr);
            return;
        }
        a.e(this.rAr.mController.xIM, this.rAr.rAn.xy(0));
    }
}
