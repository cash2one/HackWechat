package com.tencent.mm.plugin.sns.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class SnsCommentDetailUI$10 implements OnScrollListener {
    final /* synthetic */ SnsCommentDetailUI rAr;

    SnsCommentDetailUI$10(SnsCommentDetailUI snsCommentDetailUI) {
        this.rAr = snsCommentDetailUI;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.rAr.aWs();
            SnsCommentDetailUI.s(this.rAr);
        }
    }
}
