package com.tencent.mm.ui.transmit;

import com.tencent.mm.y.g.a;

class MsgRetransmitUI$10 implements Runnable {
    final /* synthetic */ String fgO;
    final /* synthetic */ MsgRetransmitUI zoG;
    final /* synthetic */ a zoK;
    final /* synthetic */ byte[] zoL;

    MsgRetransmitUI$10(MsgRetransmitUI msgRetransmitUI, String str, a aVar, byte[] bArr) {
        this.zoG = msgRetransmitUI;
        this.fgO = str;
        this.zoK = aVar;
        this.zoL = bArr;
    }

    public final void run() {
        MsgRetransmitUI.a(this.zoG, this.fgO, this.zoK, this.zoL);
    }
}
