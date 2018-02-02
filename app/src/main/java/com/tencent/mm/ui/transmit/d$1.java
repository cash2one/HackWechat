package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

class d$1 implements OnCancelListener {
    final /* synthetic */ a yxG;
    final /* synthetic */ d zpH;

    d$1(d dVar, a aVar) {
        this.zpH = dVar;
        this.yxG = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.yxG.zoO = true;
    }
}
