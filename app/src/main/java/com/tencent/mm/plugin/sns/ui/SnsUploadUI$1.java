package com.tencent.mm.plugin.sns.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mm.plugin.sns.i.f;

class SnsUploadUI$1 implements TextWatcher {
    final /* synthetic */ SnsUploadUI rLR;

    SnsUploadUI$1(SnsUploadUI snsUploadUI) {
        this.rLR = snsUploadUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (SnsUploadUI.a(this.rLR).getText().toString().trim().length() > 10) {
            View findViewById = this.rLR.findViewById(f.qEy);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
