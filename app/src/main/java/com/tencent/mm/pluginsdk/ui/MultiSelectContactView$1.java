package com.tencent.mm.pluginsdk.ui;

import android.text.Editable;
import android.text.TextWatcher;

class MultiSelectContactView$1 implements TextWatcher {
    final /* synthetic */ MultiSelectContactView vkE;

    MultiSelectContactView$1(MultiSelectContactView multiSelectContactView) {
        this.vkE = multiSelectContactView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        MultiSelectContactView.a(this.vkE);
        if (MultiSelectContactView.b(this.vkE) != null) {
            MultiSelectContactView.b(this.vkE).DO(charSequence.toString());
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
