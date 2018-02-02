package com.tencent.mm.plugin.safedevice.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;

class SecurityAccountVerifyUI$1 implements TextWatcher {
    final /* synthetic */ SecurityAccountVerifyUI pRZ;

    SecurityAccountVerifyUI$1(SecurityAccountVerifyUI securityAccountVerifyUI) {
        this.pRZ = securityAccountVerifyUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean z = (editable == null || bh.ov(editable.toString())) ? false : true;
        this.pRZ.enableOptionMenu(z);
    }
}
