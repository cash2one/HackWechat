package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;

public class ConversationOverscrollListView$b implements Runnable {
    final /* synthetic */ ConversationOverscrollListView yXF;

    public ConversationOverscrollListView$b(ConversationOverscrollListView conversationOverscrollListView) {
        this.yXF = conversationOverscrollListView;
    }

    public final void run() {
        if (ConversationOverscrollListView.a(this.yXF) != null && !ConversationOverscrollListView.a(this.yXF).cwt()) {
            x.d("MicroMsg.ConversationOverscrollListView", "jacks cancel to Show Main");
            ConversationOverscrollListView.a(this.yXF);
        }
    }
}
