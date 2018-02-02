package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;

class RegByEmailUI$9 implements TextWatcher {
    final /* synthetic */ RegByEmailUI xQa;

    RegByEmailUI$9(RegByEmailUI regByEmailUI) {
        this.xQa = regByEmailUI;
    }

    public final void afterTextChanged(Editable editable) {
        RegByEmailUI.b(this.xQa);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
