package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class z$16 implements OnClickListener {
    final /* synthetic */ z xLL;

    z$16(z zVar) {
        this.xLL = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.xLL.qwI.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
