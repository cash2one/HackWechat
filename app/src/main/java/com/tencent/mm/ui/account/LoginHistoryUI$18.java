package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class LoginHistoryUI$18 implements OnDismissListener {
    final /* synthetic */ LoginHistoryUI xPa;

    LoginHistoryUI$18(LoginHistoryUI loginHistoryUI) {
        this.xPa = loginHistoryUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        LoginHistoryUI.k(this.xPa);
    }
}
