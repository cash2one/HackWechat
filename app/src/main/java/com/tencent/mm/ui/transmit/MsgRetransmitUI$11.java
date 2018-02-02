package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MsgRetransmitUI$11 implements OnClickListener {
    final /* synthetic */ String gIT;
    final /* synthetic */ MsgRetransmitUI zoG;

    MsgRetransmitUI$11(MsgRetransmitUI msgRetransmitUI, String str) {
        this.zoG = msgRetransmitUI;
        this.gIT = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MsgRetransmitUI.a(this.zoG, this.zoG.getIntent(), this.gIT);
    }
}
