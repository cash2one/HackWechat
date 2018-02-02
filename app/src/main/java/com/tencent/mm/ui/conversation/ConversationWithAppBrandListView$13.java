package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class ConversationWithAppBrandListView$13 implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$13(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void run() {
        View childAt = this.yYl.getChildAt(0);
        x.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: " + (childAt == null ? 0 : childAt.getBottom()));
        this.yYl.smoothScrollToPositionFromTop(this.yYl.cwy(), 0, 300);
        ConversationWithAppBrandListView.o(this.yYl);
    }
}
