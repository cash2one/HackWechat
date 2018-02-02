package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class IPCallDialUI$3 implements OnClickListener {
    final /* synthetic */ IPCallDialUI nJK;

    IPCallDialUI$3(IPCallDialUI iPCallDialUI) {
        this.nJK = iPCallDialUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.nJK.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
