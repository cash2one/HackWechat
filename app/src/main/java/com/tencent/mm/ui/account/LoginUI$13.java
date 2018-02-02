package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class LoginUI$13 implements OnKeyListener {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$13(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        LoginUI.h(this.xPJ);
        return true;
    }
}
