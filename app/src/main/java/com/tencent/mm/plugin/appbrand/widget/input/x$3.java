package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import android.text.TextWatcher;

class x$3 implements TextWatcher {
    final /* synthetic */ x jZj;

    x$3(x xVar) {
        this.jZj = xVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.jZj.jKT.removeCallbacks(this.jZj.jZi);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
