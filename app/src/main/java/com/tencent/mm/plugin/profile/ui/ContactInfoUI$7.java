package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class ContactInfoUI$7 implements OnClickListener {
    final /* synthetic */ ContactInfoUI phL;

    ContactInfoUI$7(ContactInfoUI contactInfoUI) {
        this.phL = contactInfoUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.phL.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
