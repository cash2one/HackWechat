package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI.b;

class SnsCommentDetailUI$b$1 implements Runnable {
    final /* synthetic */ b rAX;

    SnsCommentDetailUI$b$1(b bVar) {
        this.rAX = bVar;
    }

    public final void run() {
        SnsCommentDetailUI.c(this.rAX.rAr).setSelection((SnsCommentDetailUI.c(this.rAX.rAr).getHeaderViewsCount() + this.rAX.rAV.size()) - 1);
    }
}
