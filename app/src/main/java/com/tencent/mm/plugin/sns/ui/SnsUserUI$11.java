package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SnsUserUI$11 implements OnClickListener {
    final /* synthetic */ SnsUserUI rMb;

    SnsUserUI$11(SnsUserUI snsUserUI) {
        this.rMb = snsUserUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.rMb.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
