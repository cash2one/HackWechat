package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a.29;

class ChattingUI$a$29$2 implements Runnable {
    final /* synthetic */ 29 ywY;

    ChattingUI$a$29$2(29 29) {
        this.ywY = 29;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        this.ywY.ywR.crb();
        x.i("MicroMsg.ChattingUI", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
