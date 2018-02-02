package com.tencent.mm.plugin.voip_cs.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class VoipCSMainUI$8 implements OnClickListener {
    final /* synthetic */ VoipCSMainUI sxP;

    VoipCSMainUI$8(VoipCSMainUI voipCSMainUI) {
        this.sxP = voipCSMainUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.sxP.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
