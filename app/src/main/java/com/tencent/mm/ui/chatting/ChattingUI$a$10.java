package com.tencent.mm.ui.chatting;

import com.tencent.mm.ui.chatting.ChattingUI.a;

class ChattingUI$a$10 implements Runnable {
    final /* synthetic */ boolean iij;
    final /* synthetic */ a ywR;
    final /* synthetic */ a.a ywS;

    ChattingUI$a$10(a aVar, boolean z, a.a aVar2) {
        this.ywR = aVar;
        this.iij = z;
        this.ywS = aVar2;
    }

    public final void run() {
        a.a(this.ywR, this.iij, this.ywS);
    }
}
