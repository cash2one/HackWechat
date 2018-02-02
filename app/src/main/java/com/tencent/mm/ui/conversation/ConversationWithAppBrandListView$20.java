package com.tencent.mm.ui.conversation;

import android.support.v7.widget.RecyclerView.c;

class ConversationWithAppBrandListView$20 extends c {
    final /* synthetic */ ConversationWithAppBrandListView yYl;

    ConversationWithAppBrandListView$20(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        this.yYl = conversationWithAppBrandListView;
    }

    public final void aa(int i, int i2) {
        super.aa(i, i2);
        if (ConversationWithAppBrandListView.c(this.yYl).fm().getItemCount() == 1) {
            ConversationWithAppBrandListView.b(this.yYl, true);
        } else {
            ConversationWithAppBrandListView.b(this.yYl, false);
        }
    }
}
