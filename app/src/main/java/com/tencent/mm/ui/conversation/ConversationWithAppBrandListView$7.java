package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;

class ConversationWithAppBrandListView$7 implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$7(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void run() {
        x.i("MicroMsg.ConversationWithAppBrandListView", "[CheckShowTipTask]");
        ConversationWithAppBrandListView.j(this.yYl);
    }
}
