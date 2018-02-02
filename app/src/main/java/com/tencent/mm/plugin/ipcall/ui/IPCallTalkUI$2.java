package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class IPCallTalkUI$2 implements OnClickListener {
    final /* synthetic */ IPCallTalkUI nNp;

    IPCallTalkUI$2(IPCallTalkUI iPCallTalkUI) {
        this.nNp = iPCallTalkUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.nNp.finish();
        this.nNp.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
