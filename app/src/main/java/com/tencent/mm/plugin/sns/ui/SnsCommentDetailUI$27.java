package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.m;

class SnsCommentDetailUI$27 implements OnClickListener {
    final /* synthetic */ boolean qPf;
    final /* synthetic */ SnsCommentDetailUI rAr;
    final /* synthetic */ m rrO;

    SnsCommentDetailUI$27(SnsCommentDetailUI snsCommentDetailUI, boolean z, m mVar) {
        this.rAr = snsCommentDetailUI;
        this.qPf = z;
        this.rrO = mVar;
    }

    public final void onClick(View view) {
        if (SnsCommentDetailUI.A(this.rAr) != null && this.qPf) {
            SnsCommentDetailUI.A(this.rAr).el(this.rrO.field_snsId);
        }
        SnsCommentDetailUI.x(this.rAr).rPU.onClick(view);
    }
}
