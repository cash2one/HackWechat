package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$27 implements Runnable {
    final /* synthetic */ a ywR;

    ChattingUI$a$27(a aVar) {
        this.ywR = aVar;
    }

    public final void run() {
        if (a.a(this.ywR) || a.b(this.ywR) != 0) {
            a.e(this.ywR);
            x.i("MicroMsg.ChattingUI", "scrollToLastProtect userTouched: %s state: %s", new Object[]{Boolean.valueOf(a.a(this.ywR)), Integer.valueOf(a.b(this.ywR))});
            return;
        }
        x.i("MicroMsg.ChattingUI", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", new Object[]{Integer.valueOf(a.f(this.ywR)), Integer.valueOf(a.c(this.ywR).getLastVisiblePosition()), Integer.valueOf(a.c(this.ywR).getCount() - 1)});
        if (a.c(this.ywR).getLastVisiblePosition() < a.c(this.ywR).getCount() - 1) {
            a.a(this.ywR, true, null);
            this.ywR.csK();
            return;
        }
        a.e(this.ywR);
    }
}
