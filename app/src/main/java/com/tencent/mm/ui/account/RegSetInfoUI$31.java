package com.tencent.mm.ui.account;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class RegSetInfoUI$31 implements OnFocusChangeListener {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$31(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            RegSetInfoUI.q(this.xSg);
            RegSetInfoUI.m(this.xSg).J(200, 200);
        }
    }
}
