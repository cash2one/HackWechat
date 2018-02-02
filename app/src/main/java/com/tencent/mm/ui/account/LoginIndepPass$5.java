package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class LoginIndepPass$5 implements OnDismissListener {
    final /* synthetic */ LoginIndepPass xPi;

    LoginIndepPass$5(LoginIndepPass loginIndepPass) {
        this.xPi = loginIndepPass;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        LoginIndepPass.g(this.xPi);
    }
}
