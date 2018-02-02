package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class a$2 implements OnDismissListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ boolean sKp;

    a$2(boolean z, Activity activity) {
        this.sKp = z;
        this.icz = activity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.sKp) {
            this.icz.finish();
        }
    }
}
