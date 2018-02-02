package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;

class LoginIndepPass$10 implements TextWatcher {
    final /* synthetic */ LoginIndepPass xPi;

    LoginIndepPass$10(LoginIndepPass loginIndepPass) {
        this.xPi = loginIndepPass;
    }

    public final void afterTextChanged(Editable editable) {
        LoginIndepPass.b(this.xPi);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
