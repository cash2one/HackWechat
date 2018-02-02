package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class SimpleLoginUI$16 implements OnEditorActionListener {
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$16(SimpleLoginUI simpleLoginUI) {
        this.xSL = simpleLoginUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        SimpleLoginUI.b(this.xSL);
        return true;
    }
}
