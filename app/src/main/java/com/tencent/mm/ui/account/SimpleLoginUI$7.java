package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class SimpleLoginUI$7 implements OnDismissListener {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$7(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        SimpleLoginUI.i(this.xSL);
    }
}
