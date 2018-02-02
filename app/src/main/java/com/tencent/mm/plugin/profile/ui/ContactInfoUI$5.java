package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ContactInfoUI$5 implements OnClickListener {
    final /* synthetic */ ContactInfoUI phL;

    ContactInfoUI$5(ContactInfoUI contactInfoUI) {
        this.phL = contactInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.phL.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
