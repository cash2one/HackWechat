package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MassSendMsgUI$2 implements OnClickListener {
    final /* synthetic */ Intent kvq;
    final /* synthetic */ MassSendMsgUI onR;

    MassSendMsgUI$2(MassSendMsgUI massSendMsgUI, Intent intent) {
        this.onR = massSendMsgUI;
        this.kvq = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MassSendMsgUI.b(this.onR, this.kvq);
    }
}
