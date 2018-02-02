package com.tencent.mm.plugin.sns.ui;

class SnsStrangerCommentDetailUI$8 implements Runnable {
    final /* synthetic */ SnsStrangerCommentDetailUI rGV;

    SnsStrangerCommentDetailUI$8(SnsStrangerCommentDetailUI snsStrangerCommentDetailUI) {
        this.rGV = snsStrangerCommentDetailUI;
    }

    public final void run() {
        SnsStrangerCommentDetailUI.a(this.rGV).setSelection(SnsStrangerCommentDetailUI.d(this.rGV).getCount() - 1);
    }
}
