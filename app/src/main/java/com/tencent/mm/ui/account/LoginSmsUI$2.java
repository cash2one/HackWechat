package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;

class LoginSmsUI$2 implements TextWatcher {
    final /* synthetic */ LoginSmsUI xPx;

    LoginSmsUI$2(LoginSmsUI loginSmsUI) {
        this.xPx = loginSmsUI;
    }

    public final void afterTextChanged(Editable editable) {
        if (this.xPx.jNX.getText().toString().length() > 0) {
            this.xPx.xOr.setEnabled(true);
        } else {
            this.xPx.xOr.setEnabled(false);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
