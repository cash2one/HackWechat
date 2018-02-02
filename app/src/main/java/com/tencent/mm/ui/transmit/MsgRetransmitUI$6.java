package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.model.k;

class MsgRetransmitUI$6 implements OnCancelListener {
    final /* synthetic */ k yCG;
    final /* synthetic */ MsgRetransmitUI zoG;

    MsgRetransmitUI$6(MsgRetransmitUI msgRetransmitUI, k kVar) {
        this.zoG = msgRetransmitUI;
        this.yCG = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.yCG.bYp();
        this.zoG.zoF = true;
        this.zoG.finish();
    }
}
