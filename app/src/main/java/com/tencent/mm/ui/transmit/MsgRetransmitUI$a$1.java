package com.tencent.mm.ui.transmit;

import android.app.Activity;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

class MsgRetransmitUI$a$1 implements Runnable {
    final /* synthetic */ a zoV;

    MsgRetransmitUI$a$1(a aVar) {
        this.zoV = aVar;
    }

    public final void run() {
        if (this.zoV.zoR && (this.zoV.context instanceof Activity)) {
            ((Activity) this.zoV.context).finish();
        }
    }
}
