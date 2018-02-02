package com.tencent.mm.ui.contact;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.normsg.a.d;

class SayHiEditUI$a implements TextWatcher {
    private boolean gSo;

    private SayHiEditUI$a() {
        this.gSo = false;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.gSo) {
            this.gSo = true;
            d.oSu.T(3, 2, 5);
        }
    }

    public final void afterTextChanged(Editable editable) {
    }
}
