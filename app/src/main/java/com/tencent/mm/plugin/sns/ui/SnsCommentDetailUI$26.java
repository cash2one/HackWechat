package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.m;

class SnsCommentDetailUI$26 implements OnClickListener {
    final /* synthetic */ int rAB;
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$26(SnsCommentDetailUI snsCommentDetailUI, int i, m mVar) {
        this.rAr = snsCommentDetailUI;
        this.rAB = i;
        this.rrO = mVar;
    }

    public final void onClick(View view) {
        if (SnsCommentDetailUI.A(this.rAr) != null && this.rAB > 0) {
            SnsCommentDetailUI.A(this.rAr).el(this.rrO.field_snsId);
        }
        SnsCommentDetailUI.x(this.rAr).rPU.onClick(view);
    }
}
