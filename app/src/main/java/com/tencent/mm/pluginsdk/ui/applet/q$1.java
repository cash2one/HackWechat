package com.tencent.mm.pluginsdk.ui.applet;

import android.text.Editable;
import android.text.TextWatcher;

class q$1 implements TextWatcher {
    final /* synthetic */ q vow;

    q$1(q qVar) {
        this.vow = qVar;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        int length = 50 - editable.length();
        if (length < 0) {
            length = 0;
        }
        if (this.vow.pym != null) {
            this.vow.pym.setText(String.valueOf(length));
        }
    }
}
