package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ContactsSyncUI$2 implements OnClickListener {
    final /* synthetic */ ContactsSyncUI ilf;

    ContactsSyncUI$2(ContactsSyncUI contactsSyncUI) {
        this.ilf = contactsSyncUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.ilf.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
