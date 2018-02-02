package com.tencent.mm.plugin.address.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.x;

class AddrEditView$3 implements TextWatcher {
    final /* synthetic */ AddrEditView ine;

    AddrEditView$3(AddrEditView addrEditView) {
        this.ine = addrEditView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        boolean XO = this.ine.XO();
        if (!(XO == AddrEditView.a(this.ine) || AddrEditView.b(this.ine) == null)) {
            x.d("MicroMsg.AddrEditView", "View:" + AddrEditView.c(this.ine) + ", editType:" + AddrEditView.d(this.ine) + " inputValid change to " + XO);
            AddrEditView.a(this.ine, XO);
            AddrEditView.b(this.ine).XL();
        }
        AddrEditView.b(this.ine, AddrEditView.e(this.ine).isFocused());
    }
}
