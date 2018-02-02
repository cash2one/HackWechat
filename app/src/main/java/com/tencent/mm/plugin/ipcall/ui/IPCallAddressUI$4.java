package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class IPCallAddressUI$4 implements OnClickListener {
    final /* synthetic */ IPCallAddressUI nID;

    IPCallAddressUI$4(IPCallAddressUI iPCallAddressUI) {
        this.nID = iPCallAddressUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.nID.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
