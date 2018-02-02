package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.w.9;

class w$9$1 implements Runnable {
    final /* synthetic */ 9 yBw;

    w$9$1(9 9) {
        this.yBw = 9;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.SilenceMsgImp", "summerbadcr needCheckHistoryTips run scrollToLastProtect BADCR_SCROLL_DELAY[%d]", new Object[]{Integer.valueOf(w.yBh)});
        w.a(this.yBw.yBn).mM(true);
    }
}
