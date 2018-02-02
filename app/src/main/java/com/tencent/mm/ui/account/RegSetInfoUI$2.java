package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class RegSetInfoUI$2 implements OnKeyListener {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$2(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        RegSetInfoUI.p(this.xSg);
        return true;
    }
}
