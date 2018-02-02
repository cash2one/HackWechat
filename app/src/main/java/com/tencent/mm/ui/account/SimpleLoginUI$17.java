package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class SimpleLoginUI$17 implements OnKeyListener {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$17(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 0) {
            return false;
        }
        SimpleLoginUI.b(this.xSL);
        return true;
    }
}
