package com.tencent.mm.plugin.accountsync.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ContactsSyncUI$3 implements OnClickListener {
    final /* synthetic */ ContactsSyncUI ilf;

    ContactsSyncUI$3(ContactsSyncUI contactsSyncUI) {
        this.ilf = contactsSyncUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.ilf.finish();
    }
}
