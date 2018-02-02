package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class IPCallContactUI$3 implements OnClickListener {
    final /* synthetic */ IPCallContactUI nIW;

    IPCallContactUI$3(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.nIW.finish();
        this.nIW.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
