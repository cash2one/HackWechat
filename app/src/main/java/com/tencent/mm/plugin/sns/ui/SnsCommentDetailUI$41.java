package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class SnsCommentDetailUI$41 implements OnClickListener {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$41(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void onClick(View view) {
        x.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
        SnsCommentDetailUI.f(this.rAr);
        if (SnsCommentDetailUI.g(this.rAr)) {
            SnsCommentDetailUI.h(this.rAr);
        }
    }
}
