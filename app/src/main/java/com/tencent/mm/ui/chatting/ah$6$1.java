package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ui.chatting.ah.6;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;

class ah$6$1 implements OnCancelListener {
    final /* synthetic */ a yxG;
    final /* synthetic */ 6 yxH;

    ah$6$1(6 6, a aVar) {
        this.yxH = 6;
        this.yxG = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.yxG.zoO = true;
    }
}
