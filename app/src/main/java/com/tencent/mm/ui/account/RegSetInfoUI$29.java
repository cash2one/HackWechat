package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;

class RegSetInfoUI$29 implements TextWatcher {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$29(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final void afterTextChanged(Editable editable) {
        CharSequence trim = RegSetInfoUI.b(this.xSg).getText().toString().trim();
        if (trim == null || trim.length() <= 16) {
            if (!RegSetInfoUI.m(this.xSg).cfK()) {
                RegSetInfoUI.m(this.xSg).TG();
            }
            RegSetInfoUI.n(this.xSg);
            if (!RegSetInfoUI.o(this.xSg)) {
                RegSetInfoUI.a(this.xSg).setText(trim);
                return;
            }
            return;
        }
        RegSetInfoUI.b(this.xSg).setText(trim.substring(0, 16));
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
