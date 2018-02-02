package com.tencent.mm.ui.conversation;

class ConversationWithAppBrandListView$4 implements Runnable {
    final /* synthetic */ ConversationWithAppBrandListView yYl;
    final /* synthetic */ boolean yYn;

    ConversationWithAppBrandListView$4(ConversationWithAppBrandListView conversationWithAppBrandListView, boolean z) {
        this.yYl = conversationWithAppBrandListView;
        this.yYn = z;
    }

    public final void run() {
        this.yYl.setSelection(0);
        this.yYl.postDelayed(new 1(this), 666);
    }
}
