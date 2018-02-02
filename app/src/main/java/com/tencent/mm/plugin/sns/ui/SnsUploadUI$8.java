package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;

class SnsUploadUI$8 implements TextWatcher {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$8(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (SnsUploadUI.a(this.rLR).getText().toString().trim().length() > 0) {
            this.rLR.enableOptionMenu(true);
        } else {
            this.rLR.enableOptionMenu(false);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
