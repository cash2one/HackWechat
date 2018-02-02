package com.tencent.mm.ui.account.mobile;

import android.text.Editable;
import android.text.TextWatcher;

class MobileInputUI$6 implements TextWatcher {
    final /* synthetic */ MobileInputUI xUi;

    MobileInputUI$6(MobileInputUI mobileInputUI) {
        this.xUi = mobileInputUI;
    }

    public final void afterTextChanged(Editable editable) {
        if (MobileInputUI.a(this.xUi, this.xUi.xTX.getText().toString())) {
            this.xUi.xQo.setEnabled(true);
        } else {
            this.xUi.xQo.setEnabled(false);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
