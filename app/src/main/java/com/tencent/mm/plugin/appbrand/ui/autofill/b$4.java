package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.text.Editable;
import android.text.TextWatcher;

class b$4 implements TextWatcher {
    final /* synthetic */ b jNZ;

    b$4(b bVar) {
        this.jNZ = bVar;
    }

    public final void afterTextChanged(Editable editable) {
        if (b.e(this.jNZ).getText().toString().length() > 0) {
            b.f(this.jNZ).setEnabled(true);
        } else {
            b.f(this.jNZ).setEnabled(false);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
