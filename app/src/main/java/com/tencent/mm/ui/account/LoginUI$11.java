package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class LoginUI$11 implements OnEditorActionListener {
    final /* synthetic */ LoginUI xPJ;

    LoginUI$11(LoginUI loginUI) {
        this.xPJ = loginUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        LoginUI.h(this.xPJ);
        return true;
    }
}
