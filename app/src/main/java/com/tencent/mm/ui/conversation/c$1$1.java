package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.c.1;

class c$1$1 implements Runnable {
    final /* synthetic */ 1 yWB;

    c$1$1(1 1) {
        this.yWB = 1;
    }

    public final void run() {
        x.d("MicroMsg.ConvUnreadHelper", "refresh main ui unread count.");
        this.yWB.yWA.yWw.notifyDataSetChanged();
        this.yWB.yWA.cwp();
    }
}
