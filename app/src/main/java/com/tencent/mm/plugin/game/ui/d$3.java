package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class d$3 implements OnClickListener {
    final /* synthetic */ d nll;

    d$3(d dVar) {
        this.nll = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nll.mContext.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
        dialogInterface.cancel();
    }
}
