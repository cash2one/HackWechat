package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class RegByEmailUI$11 implements OnKeyListener {
    final /* synthetic */ RegByEmailUI xQa;

    RegByEmailUI$11(RegByEmailUI regByEmailUI) {
        this.xQa = regByEmailUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0 || !RegByEmailUI.d(this.xQa).isChecked()) {
            return false;
        }
        RegByEmailUI.c(this.xQa);
        return true;
    }
}
