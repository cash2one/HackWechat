package com.tencent.mm.plugin.bottle.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class OpenBottleUI$2 implements OnCancelListener {
    final /* synthetic */ OpenBottleUI kDa;

    OpenBottleUI$2(OpenBottleUI openBottleUI) {
        this.kDa = openBottleUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        OpenBottleUI.c(this.kDa);
    }
}
