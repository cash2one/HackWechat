package com.tencent.mm.ui.conversation;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class ConversationWithAppBrandListView$a implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$a(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void run() {
        View childAt = this.yYl.getChildAt(0);
        if (this.yYl.getFirstVisiblePosition() == 0 && childAt != null && childAt.getTop() < 0) {
            x.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
            if (((float) childAt.getBottom()) >= ConversationWithAppBrandListView.p(this.yYl)) {
                ConversationWithAppBrandListView.q(this.yYl);
            } else {
                ConversationWithAppBrandListView.r(this.yYl);
            }
        }
    }
}
