package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;

class LoginPasswordUI$3 implements TextWatcher {
    final /* synthetic */ LoginPasswordUI xPn;

    LoginPasswordUI$3(LoginPasswordUI loginPasswordUI) {
        this.xPn = loginPasswordUI;
    }

    public final void afterTextChanged(Editable editable) {
        if (this.xPn.lTk.getText().toString().length() > 0) {
            this.xPn.xOr.setEnabled(true);
        } else {
            this.xPn.xOr.setEnabled(false);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
