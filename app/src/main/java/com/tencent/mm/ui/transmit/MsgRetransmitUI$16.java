package com.tencent.mm.ui.transmit;

import com.tencent.mm.R;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.k;

class MsgRetransmitUI$16 implements f {
    final /* synthetic */ MsgRetransmitUI zoG;

    MsgRetransmitUI$16(MsgRetransmitUI msgRetransmitUI) {
        this.zoG = msgRetransmitUI;
    }

    public final void a(int i, int i2, k kVar) {
        if (MsgRetransmitUI.b(this.zoG) != null && i2 != 0) {
            int i3 = (int) ((((long) i) * 100) / ((long) i2));
            MsgRetransmitUI.b(this.zoG).setMessage(this.zoG.getString(R.l.evO, new Object[]{Integer.valueOf(MsgRetransmitUI.c(this.zoG)), Integer.valueOf(MsgRetransmitUI.d(this.zoG)), Integer.valueOf(i3)}));
        }
    }
}
