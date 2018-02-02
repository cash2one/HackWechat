package com.tencent.mm.ui.conversation;

import android.view.View;

class ConversationWithAppBrandListView$17 implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$17(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void run() {
        if (ConversationWithAppBrandListView.c(this.yYl) != null) {
            ConversationWithAppBrandListView.c(this.yYl).smoothScrollToPosition(0);
        }
        View childAt = this.yYl.getChildAt(0);
        int bottom = childAt == null ? 0 : childAt.getBottom();
        if (bottom != 0) {
            this.yYl.smoothScrollBy(bottom, 0);
        }
        this.yYl.setSelection(0);
    }
}
