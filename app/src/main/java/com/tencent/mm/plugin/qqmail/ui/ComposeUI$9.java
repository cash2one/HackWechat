package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ComposeUI$9 implements OnClickListener {
    final /* synthetic */ ComposeUI prr;

    ComposeUI$9(ComposeUI composeUI) {
        this.prr = composeUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.prr.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
