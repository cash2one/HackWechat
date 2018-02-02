package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class VoipCSMainUI$9 implements OnClickListener {
    final /* synthetic */ VoipCSMainUI sxP;

    VoipCSMainUI$9(VoipCSMainUI voipCSMainUI) {
        this.sxP = voipCSMainUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.sxP.yX(3);
    }
}
