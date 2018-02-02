package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MsgRetransmitUI$2 implements OnClickListener {
    final /* synthetic */ MsgRetransmitUI zoG;

    MsgRetransmitUI$2(MsgRetransmitUI msgRetransmitUI) {
        this.zoG = msgRetransmitUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (MsgRetransmitUI.b(this.zoG) != null) {
            MsgRetransmitUI.b(this.zoG).cancel();
        }
    }
}
