package com.tencent.mm.plugin.game.widget;

import android.text.Editable;
import android.text.TextWatcher;

class a$a implements TextWatcher {
    final /* synthetic */ a nxI;

    private a$a(a aVar) {
        this.nxI = aVar;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.nxI.aRX();
    }

    public final void afterTextChanged(Editable editable) {
    }
}
