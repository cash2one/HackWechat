package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class LoginIndepPass$12 implements OnKeyListener {
    final /* synthetic */ LoginIndepPass xPi;

    LoginIndepPass$12(LoginIndepPass loginIndepPass) {
        this.xPi = loginIndepPass;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        LoginIndepPass.a(this.xPi);
        return true;
    }
}
