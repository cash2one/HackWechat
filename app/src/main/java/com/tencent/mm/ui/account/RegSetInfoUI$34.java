package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class RegSetInfoUI$34 implements OnEditorActionListener {
    final /* synthetic */ RegSetInfoUI xSg;

    RegSetInfoUI$34(RegSetInfoUI regSetInfoUI) {
        this.xSg = regSetInfoUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 5) {
            return false;
        }
        RegSetInfoUI.p(this.xSg);
        return true;
    }
}
