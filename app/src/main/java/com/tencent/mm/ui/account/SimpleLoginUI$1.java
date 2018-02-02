package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;

class SimpleLoginUI$1 implements TextWatcher {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$1(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final void afterTextChanged(Editable editable) {
        SimpleLoginUI.a(this.xSL);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
