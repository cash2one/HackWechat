package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;

class j$8 implements OnClickListener {
    final /* synthetic */ Dialog qSc;

    public j$8(Dialog dialog) {
        this.qSc = dialog;
    }

    public final void onClick(View view) {
        if (this.qSc != null && this.qSc.isShowing()) {
            this.qSc.dismiss();
        }
    }
}
