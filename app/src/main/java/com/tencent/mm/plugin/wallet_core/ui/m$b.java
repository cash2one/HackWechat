package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class m$b implements OnCancelListener {
    private OnCancelListener sWd;

    private m$b(OnCancelListener onCancelListener) {
        this.sWd = null;
        this.sWd = onCancelListener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        m.jR(false);
        if (this.sWd != null) {
            this.sWd.onCancel(dialogInterface);
        }
    }
}
