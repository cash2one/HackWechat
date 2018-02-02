package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class a$6 implements OnDismissListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ boolean sKp = false;

    a$6(boolean z, Activity activity) {
        this.icz = activity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.sKp) {
            this.icz.finish();
        }
    }
}
