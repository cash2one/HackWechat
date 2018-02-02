package com.tencent.mm.plugin.nearlife.ui;

import android.text.Editable;
import android.text.TextWatcher;

class NearLifeCreatePoiUI$7 implements TextWatcher {
    final /* synthetic */ NearLifeCreatePoiUI oRe;

    NearLifeCreatePoiUI$7(NearLifeCreatePoiUI nearLifeCreatePoiUI) {
        this.oRe = nearLifeCreatePoiUI;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (NearLifeCreatePoiUI.d(this.oRe).getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.f(this.oRe).getText().toString().trim().length() == 0 || NearLifeCreatePoiUI.e(this.oRe).getText().toString().trim().length() == 0) {
            this.oRe.enableOptionMenu(0, false);
        } else {
            this.oRe.enableOptionMenu(0, true);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
    }
}
