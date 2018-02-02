package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class LoginPasswordUI$1 implements OnEditorActionListener {
    final /* synthetic */ LoginPasswordUI xPn;

    LoginPasswordUI$1(LoginPasswordUI loginPasswordUI) {
        this.xPn = loginPasswordUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        this.xPn.afF();
        return true;
    }
}
