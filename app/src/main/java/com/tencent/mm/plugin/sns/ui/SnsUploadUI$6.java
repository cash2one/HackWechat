package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SnsUploadUI$6 implements OnClickListener {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$6(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.rLR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        dialogInterface.dismiss();
    }
}
