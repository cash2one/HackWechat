package com.tencent.mm.ui.transmit;

import com.tencent.mm.pluginsdk.model.k.a;

class MsgRetransmitUI$5 implements a {
    final /* synthetic */ MsgRetransmitUI zoG;

    MsgRetransmitUI$5(MsgRetransmitUI msgRetransmitUI) {
        this.zoG = msgRetransmitUI;
    }

    public final void bYr() {
        if (MsgRetransmitUI.f(this.zoG) != null) {
            MsgRetransmitUI.f(this.zoG).dismiss();
            MsgRetransmitUI.g(this.zoG);
        }
        this.zoG.finish();
    }
}
