package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class MsgRetransmitUI$3 implements OnCancelListener {
    final /* synthetic */ MsgRetransmitUI zoG;

    MsgRetransmitUI$3(MsgRetransmitUI msgRetransmitUI) {
        this.zoG = msgRetransmitUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        h.a(this.zoG, R.l.evK, R.l.dGO, R.l.dHd, R.l.dFR, new 1(this), new 2(this));
    }
}
