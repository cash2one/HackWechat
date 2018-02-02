package com.tencent.mm.plugin.multitalk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class MultiTalkMainUI$4 implements OnClickListener {
    final /* synthetic */ MultiTalkMainUI oHM;

    MultiTalkMainUI$4(MultiTalkMainUI multiTalkMainUI) {
        this.oHM = multiTalkMainUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oHM.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
