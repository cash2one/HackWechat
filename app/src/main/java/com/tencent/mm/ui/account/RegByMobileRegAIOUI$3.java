package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;

class RegByMobileRegAIOUI$3 implements TextWatcher {
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$3(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        RegByMobileRegAIOUI.b(this.xQK);
    }
}
