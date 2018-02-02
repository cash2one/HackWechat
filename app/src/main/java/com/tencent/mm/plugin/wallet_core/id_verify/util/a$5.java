package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class a$5 implements OnCancelListener {
    final /* synthetic */ Activity icz;
    final /* synthetic */ boolean sKp = false;

    a$5(boolean z, Activity activity) {
        this.icz = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.sKp) {
            this.icz.finish();
        }
    }
}
