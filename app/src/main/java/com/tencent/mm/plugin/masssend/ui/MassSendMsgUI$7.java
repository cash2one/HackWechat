package com.tencent.mm.plugin.masssend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class MassSendMsgUI$7 implements OnClickListener {
    final /* synthetic */ MassSendMsgUI onR;

    MassSendMsgUI$7(MassSendMsgUI massSendMsgUI) {
        this.onR = massSendMsgUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.onR.finish();
    }
}
