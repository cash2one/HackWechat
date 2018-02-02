package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.ae.1.1;

class ae$1$1$1 implements Runnable {
    final /* synthetic */ int kI;
    final /* synthetic */ 1 yCM;

    ae$1$1$1(1 1, int i) {
        this.yCM = 1;
        this.kI = i;
    }

    public final void run() {
        x.i("MicroMsg.ChattingUI.VoiceImp", "position " + this.kI);
        t.a(this.yCM.yCL.yCJ.fhr.csx(), this.kI, false);
    }
}
