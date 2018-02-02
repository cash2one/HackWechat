package com.tencent.mm.ui.account;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class RegByEmailUI$10 implements OnEditorActionListener {
    final /* synthetic */ RegByEmailUI xQa;

    RegByEmailUI$10(RegByEmailUI regByEmailUI) {
        this.xQa = regByEmailUI;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if ((i != 6 && i != 5) || !RegByEmailUI.d(this.xQa).isChecked()) {
            return false;
        }
        RegByEmailUI.c(this.xQa);
        return true;
    }
}
