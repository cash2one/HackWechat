package com.tencent.mm.plugin.recharge.ui.form;

import android.text.Editable;
import android.text.TextWatcher;

class MallFormView$1 implements TextWatcher {
    private boolean pEM = false;
    final /* synthetic */ MallFormView pEN;

    MallFormView$1(MallFormView mallFormView) {
        this.pEN = mallFormView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.pEN.XO() != this.pEM) {
            if (MallFormView.c(this.pEN) != null) {
                MallFormView.c(this.pEN).hx(this.pEN.XO());
            }
            this.pEM = this.pEN.XO();
        }
        this.pEN.bmI();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
