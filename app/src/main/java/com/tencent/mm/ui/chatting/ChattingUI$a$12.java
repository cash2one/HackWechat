package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$12 implements Runnable {
    final /* synthetic */ a ywR;

    ChattingUI$a$12(a aVar) {
        this.ywR = aVar;
    }

    public final void run() {
        if (a.a(this.ywR) || a.b(this.ywR) != 0) {
            x.w("MicroMsg.ChattingUI", "error state user has touch listview, not need to scroll to last. userTouched: %s state: %s", new Object[]{Boolean.valueOf(a.a(this.ywR)), Integer.valueOf(a.b(this.ywR))});
            return;
        }
        x.i("MicroMsg.ChattingUI", "first time in, scroll to last");
        a.a(this.ywR, true, null);
    }
}
