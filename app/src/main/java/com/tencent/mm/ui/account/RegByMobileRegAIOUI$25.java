package com.tencent.mm.ui.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.ao;

class RegByMobileRegAIOUI$25 implements TextWatcher {
    private ao nHl = new ao();
    final /* synthetic */ RegByMobileRegAIOUI xQK;

    RegByMobileRegAIOUI$25(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.xQK = regByMobileRegAIOUI;
    }

    public final void afterTextChanged(Editable editable) {
        RegByMobileRegAIOUI.b(this.xQK);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
