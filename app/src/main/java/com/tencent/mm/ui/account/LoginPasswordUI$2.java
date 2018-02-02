package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class LoginPasswordUI$2 implements OnKeyListener {
    final /* synthetic */ LoginPasswordUI xPn;

    LoginPasswordUI$2(LoginPasswordUI loginPasswordUI) {
        this.xPn = loginPasswordUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        this.xPn.afF();
        return true;
    }
}
